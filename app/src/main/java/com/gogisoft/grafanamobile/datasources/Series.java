package com.gogisoft.grafanamobile.datasources;

import android.graphics.Point;
import android.graphics.PointF;

import java.util.List;


public class Series {
    private List<PointF> points;

    public Series(List<PointF> points) {
        this.points = points;
    }

    public List<PointF> getPoints() {
        return points;
    }
}
