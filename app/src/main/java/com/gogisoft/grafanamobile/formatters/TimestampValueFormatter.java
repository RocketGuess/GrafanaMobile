package com.gogisoft.grafanamobile.formatters;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class TimestampValueFormatter implements IAxisValueFormatter {
    public TimestampValueFormatter() {
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return Timestamp.fromFloat(value);
    }
}
