package com.gogisoft.grafanamobile.datasources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.gogisoft.grafanamobile.App;
import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.Target;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusData;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusQueryResponce;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusResult;
import com.gogisoft.grafanamobile.panels.TargetWrapper;
import com.gogisoft.grafanamobile.panels.TargetWrapper.TargetType;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Datasource {
    private String name;
    private GrafanaClient client;

    public static abstract class Callback {
        protected View view;
        protected TargetWrapper target;

        public Callback(View view, TargetWrapper target) {
            this.view = view;
            this.target = target;
        }

        public abstract void call(List<Series> series);
    }

    public Datasource(String name) {
        this.name = name;
        this.client = App.getGrafanaClient();
    }

    public void query(TargetWrapper targetWrapper, final Datasource.Callback callback) {
        Target terget = targetWrapper.getTarget();
        int nowDate = (int)(Calendar.getInstance().getTime().getTime() / 1000);
        String timeStart = Integer.toString(nowDate - (5 * 60));
        String timeEnd = Integer.toString(nowDate);
        String step = "10s";

        switch (targetWrapper.getTargetType()) {
            case Prometheus: {
                client.queryPrometheus(
                    this.name,
                    terget.getExpr(),
                    timeStart,
                    timeEnd,
                    step
                ).enqueue(new retrofit2.Callback<PrometheusQueryResponce>() {
                    @Override
                    public void onResponse(Call<PrometheusQueryResponce> call, Response<PrometheusQueryResponce> response) {
                        List<Series> series = new ArrayList<Series>();

                        for (PrometheusResult result : response.body().getData().getResult()) {
                            List<Series.Point> points = new ArrayList<Series.Point>();
                            for (List<Double> value : result.getValues()) {
                                double pointValue = value.get(1);
                                long pointTime = value.get(0).longValue();
                                points.add(new Series.Point(pointValue, pointTime));
                            }

                            series.add(new Series(points, result.getMetric()));
                        }

                        callback.call(series);
                    }
                    @Override
                    public void onFailure(Call<PrometheusQueryResponce> call, Throwable t) {
                        Log.e("Some error", "error");
                    }
                });

                break;
            }
            default: {
                break;
            }
        }
    }
}
