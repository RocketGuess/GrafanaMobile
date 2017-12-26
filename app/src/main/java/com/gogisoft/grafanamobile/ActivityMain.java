package com.gogisoft.grafanamobile;

import java.util.Calendar;
import java.util.List;

import com.gogisoft.grafanamobile.R;
import com.appeaser.sublimepickerlibrary.SublimePicker;
import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.helpers.SublimeListenerAdapter;
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker.RecurrenceOption;
import com.gogisoft.grafanamobile.adapters.DashboardsAdapter;
import com.gogisoft.grafanamobile.api_client.GrafanaClient;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;
import com.gogisoft.grafanamobile.datasources.QueryTimeParams;
import com.gogisoft.grafanamobile.fragments.Dashboard;
import com.gogisoft.grafanamobile.fragments.DatePicker;
import com.gogisoft.grafanamobile.fragments.Settings;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import retrofit2.Callback;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import retrofit2.Call;
import retrofit2.Response;


public class ActivityMain extends AppCompatActivity {
    private static GrafanaClient client;
    private ListView dashboardsListView;
    private static QueryTimeParams queryTimeParams;
    private DashboardsListModel currentDashboard;
    private DatePicker pickerFrag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = App.getGrafanaClient();

        dashboardsListView = (ListView)this.findViewById(R.id.dashboards_list);

        loadDashboards();

        setDefaultQueryTimeParams();

        setDatePicker();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
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
                currentDashboard = list.get(index);

                drawDashboard(currentDashboard);

                FlowingDrawer mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
                mDrawer.closeMenu();
            }
        });
    }

    private void drawDashboard(DashboardsListModel dashboard) {
        if (dashboard != null) {
            FragmentTransaction fTrans = getFragmentManager().beginTransaction();

            Dashboard fragment = new Dashboard();
            fragment.setDashboardMeta(dashboard);

            fTrans.add(R.id.dashboard_container, (Fragment)fragment);
            fTrans.commit();
        }
    }

    private void setDatePicker() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.setTimeInMillis(queryTimeParams.startTime);
        end.setTimeInMillis(queryTimeParams.endTime);

        pickerFrag = new DatePicker(start, end, new DatePicker.Callback(){

            @Override
            public void onDateSet(Calendar start, Calendar end) {
                queryTimeParams.startTime = start.getTime().getTime();
                queryTimeParams.endTime = end.getTime().getTime();

                if (queryTimeParams.startTime > queryTimeParams.endTime) {
                    long buf = queryTimeParams.startTime;
                    queryTimeParams.startTime = queryTimeParams.endTime;
                    queryTimeParams.endTime = buf;
                }

                if(queryTimeParams.startTime == queryTimeParams.endTime) {
                    queryTimeParams.startTime -= 60000 * 60;
                }

                drawDashboard(currentDashboard);
            }
        });

        pickerFrag.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }


    private void setDefaultQueryTimeParams() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        start.add(Calendar.HOUR, -1);

        queryTimeParams = new QueryTimeParams(start.getTimeInMillis(), end.getTimeInMillis());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.time_pick:
                pickerFrag.show(getSupportFragmentManager(), "SUBLIME_PICKER");

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public static QueryTimeParams getQueryTimeParams() {
        return queryTimeParams;
    }

}
