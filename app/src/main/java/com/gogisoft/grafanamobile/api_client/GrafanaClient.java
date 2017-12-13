package com.gogisoft.grafanamobile.api_client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;


// This class represent api for grafana: http://docs.grafana.org/http_api/
public interface GrafanaClient {
    @GET("/api/search/")
    Call<List<DashboardsListModel>> getDashboardsList();
}
