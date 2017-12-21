package com.gogisoft.grafanamobile.datasources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.gogisoft.grafanamobile.App;
import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.DatasourceSettings;
import com.gogisoft.grafanamobile.api_client.models.FrontendSettingsResponce;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Target;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusData;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusQueryResponce;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusResult;
import com.gogisoft.grafanamobile.formatters.Timestamp;

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
    private String timeStart;
    private String timeEnd;
    private String timeStep;

    public static abstract class Callback {
        protected View view;
        protected Target target;
        protected Panel panel;

        public Callback(View view, Target target, Panel panel) {
            this.view = view;
            this.target = target;
            this.panel = panel;
        }

        public abstract void call(List<Series> series);
    }

    public Datasource(String name) {
        this.name = name;
        this.client = App.getGrafanaClient();
    }

    public void query(final Target target, final Datasource.Callback callback) {
        final String datasource = this.name;

        final QueryTimeParams queryTime = getTime();

        client.getFrontendSettings().enqueue(new retrofit2.Callback<FrontendSettingsResponce>() {
            @Override
            public void onResponse(Call<FrontendSettingsResponce> call, Response<FrontendSettingsResponce> response) {
                FrontendSettingsResponce settings = response.body();

                if (datasource == null) {
                    query(
                        settings.getDatasources().get(settings.getDefaultDatasource()),
                        target,
                        queryTime,
                        callback
                    );
                } else {
                    query(
                        settings.getDatasources().get(datasource),
                        target,
                        queryTime,
                        callback
                    );
                }
            }

            @Override
            public void onFailure(Call<FrontendSettingsResponce> call, Throwable t) {
                Log.e("Some error", "error");
            }
        });
    }

    private void query(DatasourceSettings datasorce, Target target, QueryTimeParams queryTime, Callback callback) {
        switch (datasorce.getType()) {
            case "prometheus":
                queryPrometheus(datasorce.getName(), target, queryTime, callback);
                break;

            default:
                break;
        }
    }

    public void queryPrometheus(String name, final Target target, final QueryTimeParams time, final Callback callback) {
        client.queryPrometheus(
            name,
            target.getExpr(),
            time.getStartTime(),
            time.getEndTime(),
            time.getStepTime()
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
                            time.step,
                            time.startTime,
                            time.endTime
                        );

                        points.add(new Series.Point(pointValue, pointTime));
                    }

                    series.add(new Series(points, result.getMetric(), target.getLegendFormat()));
                }

                callback.call(series);
            }
            @Override
            public void onFailure(Call<PrometheusQueryResponce> call, Throwable t) {
                Log.e("Some error", "error");
            }
        });
    }

    private QueryTimeParams getTime() {
        Calendar calendar = Calendar.getInstance();
        final long end = (calendar.getTime().getTime() / 1000);
        calendar.add(Calendar.MINUTE, -5);
        final long start = (calendar.getTime().getTime() / 1000);

        return new QueryTimeParams(start, end, 10);
    }
}
