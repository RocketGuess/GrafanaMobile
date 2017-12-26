package com.gogisoft.grafanamobile.adapters;

import java.util.ArrayList;
import java.util.List;

import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.api_client.models.DashboardsListModel;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Row;
import com.gogisoft.grafanamobile.panels.PanelContent;
import com.gogisoft.grafanamobile.panels.PanelGraph;
import com.gogisoft.grafanamobile.panels.PanelUnavailable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashboardsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<DashboardsListModel> dashboards;

    public DashboardsAdapter(Context context, List<DashboardsListModel> dashboards) {
        this.context = context;
        this.dashboards = dashboards;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dashboards.size();
    }

    @Override
    public Object getItem(int position) {
        return dashboards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.dashboard_list_item, parent, false);
        }

        DashboardsListModel dashboard = this.dashboards.get(position);

        TextView textView = (TextView)view.findViewById(R.id.dashboard_list_item_title);

        textView.setText(dashboard.getTitle());

        return view;
    }


}
