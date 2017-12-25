package com.gogisoft.grafanamobile.datasources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gogisoft.grafanamobile.App;
import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.DatasourceSettings;
import com.gogisoft.grafanamobile.api_client.models.FrontendSettingsResponce;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Target;
import com.gogisoft.grafanamobile.api_client.models.graphite.GraphiteQueryResponce;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusData;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusQueryResponce;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusResult;

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

    public void query(final Target target, final QueryTimeParams queryTime, final Datasource.Callback callback) {
        final String datasource = this.name;

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
            case "graphite":
                queryGraphite(datasorce.getId(), target, queryTime, callback);
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
            target.getStepByRange(time.getRange()) + "s"
        ).enqueue(new retrofit2.Callback<PrometheusQueryResponce>() {
            @Override
            public void onResponse(Call<PrometheusQueryResponce> call, Response<PrometheusQueryResponce> response) {
                List<Series> series = new ArrayList<Series>();

                for (PrometheusResult result : response.body().getData().getResult()) {
                    List<Series.Point> points = new ArrayList<Series.Point>();
                    for (List<Double> value : result.getValues()) {
                        Double pointValue = value.get(1);
                        Double pointTime = value.get(0);

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

    public void queryGraphite(String id, final Target target, final QueryTimeParams time, final Callback callback) {
        client.queryGraphite(
            id,
            target.getTarget(),
            time.getStartTime(),
            time.getEndTime(),
            "json",
            target.getPoints() + ""
        ).enqueue(new retrofit2.Callback<List<GraphiteQueryResponce>>() {
            @Override
            public void onResponse(Call<List<GraphiteQueryResponce>> call, Response<List<GraphiteQueryResponce>> response) {
                List<Series> series = new ArrayList<Series>();

                if (response.body() != null) {
                    for (GraphiteQueryResponce result : response.body()) {
                        List<Series.Point> points = new ArrayList<Series.Point>();
                        for (List<Double> value : result.getDatapoints()) {
                            Double pointValue = value.get(0);
                            Double pointTime = value.get(1);

                            points.add(new Series.Point(pointValue, pointTime));
                        }

                        Map<String, String> tags = new HashMap<String, String>();
                        tags.put("name", result.getTarget());

                        series.add(new Series(points, tags, "{{name}}"));
                    }
                }

                callback.call(series);
            }

            @Override
            public void onFailure(Call<List<GraphiteQueryResponce>> call, Throwable t) {
                Log.e("Some error", "error");
            }
        });
    }
}
