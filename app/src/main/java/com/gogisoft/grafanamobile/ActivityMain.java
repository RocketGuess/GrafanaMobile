package com.gogisoft.grafanamobile;

import java.util.List;

import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;
import com.gogisoft.grafanamobile.fragments.Dashboard;
import com.gogisoft.grafanamobile.fragments.Settings;

import retrofit2.Callback;

import android.app.Activity;
import android.os.Bundle;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ActivityMain extends MaterialNavigationDrawer {
    private static GrafanaClient client;

    @Override
    public void init(Bundle savedInstanceState) {
        App app = (App)this.getApplication();
        client = app.getGrafanaClient();

        addSettingsSection();

        loadDashboards();
    }

    private void loadDashboards() {
        client.getDashboardsList().enqueue(new Callback<List<DashboardsListModel>>() {
            @Override
            public void onResponse(Call<List<DashboardsListModel>> call, Response<List<DashboardsListModel>> response) {
                List<DashboardsListModel> list = response.body();

                updateDashboardsList(list);
            }

            @Override
            public void onFailure(Call<List<DashboardsListModel>> call, Throwable t) {
            }
        });
    }

    private void updateDashboardsList(List<DashboardsListModel> list) {
        for (DashboardsListModel dashboard : list) {
            MaterialSection<Dashboard> section = this.newSection(
                dashboard.getTitle(),
                new Dashboard(dashboard)
            );

            this.addSection(section);
        }
    }

    private void addSettingsSection() {
        MaterialSection<Settings> section = this.newSection(
            "Settings",
            new Settings()
        );

        this.addSection(section);
    }
}
