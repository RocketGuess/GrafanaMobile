package com.gogisoft.grafanamobile.panels;

import java.util.ArrayList;
import java.util.List;

import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Target;
import com.gogisoft.grafanamobile.datasources.Datasource;
import com.gogisoft.grafanamobile.panels.TargetWrapper;
import com.gogisoft.grafanamobile.datasources.Series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PanelContent {
    private Datasource datasource;
    private List<TargetWrapper> targets;
    private Panel panel;
    private LayoutInflater inflater;
    private ViewGroup group;
    private int resource;

    public PanelContent(Panel panel, ViewGroup group, int resource,
                        LayoutInflater inflater) {
        this.panel = panel;
        this.group = group;
        this.resource = resource;
        this.inflater = inflater;

        this.targets = new ArrayList<TargetWrapper>();
        for (Target target : panel.getTargets()) {
            this.targets.add(new TargetWrapper(target));
        }

        this.datasource = new Datasource(panel.getDatasource());
    }

    public View getView(View view) {
        if (view == null) {
            view = this.inflater.inflate(this.resource, this.group, false);

            drawPanel(view, panel);

            for (TargetWrapper target : this.targets) {
                datasource.query(target, new Datasource.Callback(view, target){
                    @Override
                    public void call(List<Series> series) {
                        drawTarget(this.view, this.target, series);
                    }
                });
            }
        }

        return view;
    }

    protected abstract void drawPanel(View view, Panel panel);

    protected abstract void drawTarget(View view, TargetWrapper target, List<Series> series);
}
