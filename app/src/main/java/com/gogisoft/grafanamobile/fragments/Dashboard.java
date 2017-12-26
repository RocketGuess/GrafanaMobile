package com.gogisoft.grafanamobile.fragments;

import java.util.List;

import com.gogisoft.grafanamobile.App;
import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.adapters.DashboardRowsAdapter;
import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;
import com.gogisoft.grafanamobile.api_client.models.Row;
import com.gogisoft.grafanamobile.api_client.models.DashboardFull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



public class Dashboard extends Fragment {
    private static DashboardsListModel dashboardMeta;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        view = inflater.inflate(R.layout.fragment_dashboard,container,false);

        loadDashboard();

        return view;
    }

    private void loadDashboard() {
        App app = (App)this.getActivity().getApplication();
        GrafanaClient client = app.getGrafanaClient();

        client.getDashboard(dashboardMeta.getUri()).enqueue(new Callback<DashboardFull>() {
            @Override
            public void onResponse(Call<DashboardFull> call, Response<DashboardFull> response) {
                DashboardFull dashboard = response.body();

                loadDashboard(dashboard);
            }

            @Override
            public void onFailure(Call<DashboardFull> call, Throwable t) {
                Log.e("Some error", "error");
            }
        });

    }

    private void loadDashboard(DashboardFull dashboard) {
        ListView rowsView = (ListView)view.findViewById(R.id.rows_list);

        List<Row> rows = dashboard.getDashboard().getRows();

        DashboardRowsAdapter adapter = new DashboardRowsAdapter(this.getActivity(), rows);

        rowsView.setAdapter(adapter);
    }

    public void setDashboardMeta(DashboardsListModel dashboard) {
        this.dashboardMeta = dashboard;
    }

}
