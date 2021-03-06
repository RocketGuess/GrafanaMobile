package com.gogisoft.grafanamobile.panels;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.api_client.models.Target;
import com.gogisoft.grafanamobile.datasources.Series;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PanelGraph extends PanelContent {
    private Context context;
    private GraphView graph;
    private Panel panel;

    public PanelGraph(Panel panel, ViewGroup group, LayoutInflater inflater) {
        super(panel, group, R.layout.panel_graph, inflater);
        this.context = inflater.getContext();
    }

    @Override
    protected void drawPanel(View view, Panel panel) {
        this.graph = (GraphView)view;
        this.panel = panel;

        setGraphSettings();
    }

    @Override
    protected void drawTarget(View view, Target target, List<Series> series) {
        for (Series one_series : series) {
            if(one_series.getPoints().size() == 0) {
                continue;
            }

            List<DataPoint> points = new ArrayList<DataPoint>();
            for (Series.Point point : one_series.getPoints()) {
                points.add(new DataPoint(getDate(point.time), point.value));
            }

            LineGraphSeries<DataPoint> graphSeries = new LineGraphSeries<DataPoint>(points.toArray(new DataPoint[] {}));

            graph.getViewport().setMinX(points.get(0).getX());
            graph.getViewport().setMaxX(points.get(points.size() - 1).getX());

            setSeriesSettings(one_series, graphSeries);

            graph.addSeries(graphSeries);
        }
    }

    private void setSeriesSettings(Series series, LineGraphSeries<DataPoint> graphSeries) {
        graphSeries.setColor(series.getColor());
        graphSeries.setDrawBackground(panel.getFill() > 0);
        graphSeries.setTitle(series.getName());
        graphSeries.setDrawDataPoints(panel.getPoints());
        graphSeries.setDataPointsRadius(8);
        graphSeries.setThickness(5);

        int alpha = 20;
        int red = Color.red(series.getColor());
        int green = Color.green(series.getColor());
        int blue = Color.blue(series.getColor());
        graphSeries.setBackgroundColor(Color.argb(alpha, red, green, blue));
    }

    private void setGraphSettings() {
        graph.getViewport().setScalable(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getGridLabelRenderer().setGridColor(Color.WHITE);
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);

        graph.getGridLabelRenderer().setLabelFormatter(
            new DateAsXAxisLabelFormatter(
                context,
                new SimpleDateFormat("mm:ss")
            )
        );
        graph.getGridLabelRenderer().setNumHorizontalLabels(4);
    }

    private static Date getDate(Double time) {
        return new Date(time.longValue() * 1000);
    }
}
