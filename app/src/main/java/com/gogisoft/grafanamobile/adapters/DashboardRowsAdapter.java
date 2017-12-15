package com.gogisoft.grafanamobile.adapters;

import java.util.ArrayList;
import java.util.List;

import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Row;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DashboardRowsAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Row> rows;

    public DashboardRowsAdapter(Context context, List<Row> rows) {
        this.context = context;
        this.rows = rows;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return rows.size();
    }

    @Override
    public Object getItem(int position) {
        return rows.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.dashboard_row, parent, false);
        }

        ViewGroup rowGroup = (ViewGroup)view;

        Row row = this.rows.get(position);

        for (Panel panel : row.getPanels()) {
            View panelView = inflater.inflate(R.layout.dashboard_panel, rowGroup, false);

            TextView title_view = (TextView)panelView.findViewById(R.id.graph_title);

            title_view.setText(panel.getTitle());

            rowGroup.addView(panelView);
        }

        return view;
    }


}
