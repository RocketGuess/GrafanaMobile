package com.gogisoft.grafanamobile.api_client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.gogisoft.grafanamobile.api_client.models.DashboardFull;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;
import com.gogisoft.grafanamobile.api_client.models.FrontendSettingsResponce;
import com.gogisoft.grafanamobile.api_client.models.prometheus.PrometheusQueryResponce;


// This class represent api for grafana: http://docs.grafana.org/http_api/
public interface GrafanaClient {
    @GET("/api/search/")
    Call<List<DashboardsListModel>> getDashboardsList();

    @GET("/api/dashboards/{uri}")
    Call<DashboardFull> getDashboard(@Path("uri") String uri);

    @GET("/api/datasources/proxy/{datasource_name}/api/v1/query_range")
    Call<PrometheusQueryResponce> queryPrometheus(
        @Path("datasource_name") String datasource_name,
        @Query("query") String query,
        @Query("start") String start,
        @Query("end") String end,
        @Query("step") String step
    );

    @GET("/api/frontend/settings")
    Call<FrontendSettingsResponce> getFrontendSettings();
}
