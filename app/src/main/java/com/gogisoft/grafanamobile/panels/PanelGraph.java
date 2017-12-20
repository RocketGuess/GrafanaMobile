package com.gogisoft.grafanamobile.panels;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.panels.TargetWrapper;
import com.gogisoft.grafanamobile.datasources.Series;
import com.gogisoft.grafanamobile.formatters.TimestampValueFormatter;

import android.R.color;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PanelGraph extends PanelContent {
    private Context context;
    private LineChart chart;

    public PanelGraph(Panel panel, ViewGroup group, LayoutInflater inflater) {
        super(panel, group, R.layout.panel_graph, inflater);
        this.context = inflater.getContext();
    }

    @Override
    protected void drawPanel(View view, Panel panel) {
        this.chart = (LineChart)view;

        setAxisSettings(chart);
    }

    @Override
    protected void drawTarget(View view, TargetWrapper target, List<Series> series) {
        LineData lineData = new LineData();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -5);
        long year = (calendar.getTime().getTime() / 1000);

        for (Series one_series : series) {
            List<Entry> entries = new ArrayList<Entry>();
            for (Series.Point point : one_series.getPoints()) {
                float x = point.time.toFloat();
                float y = (float)point.value;
                entries.add(new Entry(x, y));
            }

            LineDataSet dataSet = new LineDataSet(entries, one_series.getName());

            setDataSetSettings(dataSet, one_series);

            lineData.addDataSet(dataSet);
        }

        setLegend(chart);

        chart.setData(lineData);
        chart.invalidate();
    }

    private void setDataSetSettings(LineDataSet dataSet, Series series) {
        dataSet.setColor(series.getColor());
        dataSet.setFillColor(series.getColor());
        dataSet.setDrawFilled(true);
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
    }

    private void setAxisSettings(LineChart chart) {
        XAxis xAxis = chart.getXAxis();
        YAxis leftAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();

        xAxis.setTextColor(ContextCompat.getColor(context, R.color.graph_axis));
        leftAxis.setTextColor(ContextCompat.getColor(context, R.color.graph_axis));

        rightAxis.setEnabled(false);

        xAxis.setPosition(XAxisPosition.BOTTOM);

        xAxis.setValueFormatter(new TimestampValueFormatter());
    }

    private void setLegend(LineChart chart) {
        chart.getLegend().setEnabled(true);
        chart.getLegend().setTextColor(Color.WHITE);
    }
}
