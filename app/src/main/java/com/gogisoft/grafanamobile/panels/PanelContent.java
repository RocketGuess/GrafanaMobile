package com.gogisoft.grafanamobile.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gogisoft.grafanamobile.ActivityMain;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Target;
import com.gogisoft.grafanamobile.datasources.Datasource;
import com.gogisoft.grafanamobile.datasources.QueryTimeParams;
import com.gogisoft.grafanamobile.datasources.Series;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class PanelContent {
    private Datasource datasource;
    private List<Target> targets;
    private Panel panel;
    private LayoutInflater inflater;
    private ViewGroup group;
    private int resource;
    private QueryTimeParams queryTimeParams;

    public PanelContent(Panel panel, ViewGroup group, int resource,
                        LayoutInflater inflater) {
        this.panel = panel;
        this.group = group;
        this.resource = resource;
        this.inflater = inflater;

        this.targets = panel.getTargets();

        this.datasource = new Datasource(panel.getDatasource());
        this.queryTimeParams = ActivityMain.getQueryTimeParams();
    }

    public View getView(View view) {
        if (view == null) {
            view = this.inflater.inflate(this.resource, this.group, false);

            drawPanel(view, panel);

            for (Target target : this.targets) {
                datasource.query(target, queryTimeParams, new Datasource.Callback(view, target, panel){
                    @Override
                    public void call(List<Series> series) {
                        if(this.panel.getAliasColors() != null) {
                            this.setColors(series);
                        }

                        drawTarget(this.view, this.target, series);
                    }

                    private void setColors(List<Series> series) {
                        Map<String, String> colors = this.panel.getAliasColors();

                        int colorsCounter = 0;
                        for (Series one_series : series) {
                            String name = one_series.getName();
                            if(colors.containsKey(name)) {
                                String color = colors.get(name);
                                one_series.setColor(Color.parseColor(color));
                            } else {
                                switch (colorsCounter % 4) {
                                    case 0:
                                        one_series.setColor(Color.GREEN);
                                        break;
                                    case 1:
                                        one_series.setColor(Color.YELLOW);
                                        break;
                                    case 2:
                                        one_series.setColor(Color.BLUE);
                                        break;
                                    case 3:
                                        one_series.setColor(Color.RED);
                                        break;
                                }

                                colorsCounter++;
                            }
                        }
                    }
                });
            }
        }

        return view;
    }

    protected abstract void drawPanel(View view, Panel panel);

    protected abstract void drawTarget(View view, Target target, List<Series> series);
}
