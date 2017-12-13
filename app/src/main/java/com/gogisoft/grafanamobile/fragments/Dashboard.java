package com.gogisoft.grafanamobile.fragments;

import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Dashboard extends Fragment {
    private DashboardsListModel dashboardMeta;

    public Dashboard(DashboardsListModel dashboardMeta) {
        this.dashboardMeta = dashboardMeta;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        View view = inflater.inflate(R.layout.activity_main,container,false);

        return view;
    }


}
