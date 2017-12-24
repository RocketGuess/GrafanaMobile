package com.gogisoft.grafanamobile;

import java.util.List;

import com.gogisoft.grafanamobile.adapters.DashboardsAdapter;
import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;
import com.gogisoft.grafanamobile.fragments.Dashboard;
import com.gogisoft.grafanamobile.fragments.Settings;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import retrofit2.Callback;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import retrofit2.Call;
import retrofit2.Response;


public class ActivityMain extends AppCompatActivity {
    private static GrafanaClient client;
    private ListView dashboardsListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = App.getGrafanaClient();

        dashboardsListView = (ListView)this.findViewById(R.id.dashboards_list);

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
            public void onFailure(Call<List<DashboardsListModel>> call, Throwable t) {}
        });
    }

    private void updateDashboardsList(final List<DashboardsListModel> list) {

        DashboardsAdapter adapter = new DashboardsAdapter(this, list);

        dashboardsListView.setAdapter(adapter);

        dashboardsListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long arg3) {
                FragmentTransaction fTrans = getFragmentManager().beginTransaction();
                Dashboard fragment = new Dashboard();
                fragment.setDashboardMeta(list.get(index));
                fTrans.add(R.id.dashboard_container, (Fragment)fragment);
                fTrans.commit();
                FlowingDrawer mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
                mDrawer.closeMenu();
            }
        });
    }
}
