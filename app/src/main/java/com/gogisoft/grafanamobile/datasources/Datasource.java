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
import com.gogisoft.grafanamobile.formatters.Timestamp;
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

        Calendar calendar = Calendar.getInstance();
        final long end = (calendar.getTime().getTime() / 1000);
        calendar.add(Calendar.MINUTE, -5);
        final long start = (calendar.getTime().getTime() / 1000);
        final int step = 10;

        String timeStart = Long.toString(start);
        String timeEnd = Long.toString(end);
        String timeStep = step + "s";

        switch (targetWrapper.getTargetType()) {
            case Prometheus: {
                client.queryPrometheus(
                    this.name,
                    terget.getExpr(),
                    timeStart,
                    timeEnd,
                    timeStep
                ).enqueue(new retrofit2.Callback<PrometheusQueryResponce>() {
                    @Override
                    public void onResponse(Call<PrometheusQueryResponce> call, Response<PrometheusQueryResponce> response) {
                        List<Series> series = new ArrayList<Series>();

                        for (PrometheusResult result : response.body().getData().getResult()) {
                            List<Series.Point> points = new ArrayList<Series.Point>();
                            for (List<Double> value : result.getValues()) {
                                double pointValue = value.get(1);
                                Timestamp pointTime = new Timestamp(
                                    value.get(0).longValue(),
                                    step,
                                    start,
                                    end
                                );

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
