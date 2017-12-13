package com.gogisoft.grafanamobile;

import android.app.Application;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.gogisoft.grafanamobile.api_client.GrafanaClient;

public class App extends Application {
    private Retrofit retrofit;
    private GrafanaClient client;

    @Override
    public void onCreate() {
        this.buildGrafanaClient();
    }

    private void buildGrafanaClient() {
        retrofit = new Retrofit.Builder()
        .baseUrl("http://play.grafana.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

        client = retrofit.create(GrafanaClient.class);
    }

    public GrafanaClient getGrafanaClient() {
        return client;
    }
}
