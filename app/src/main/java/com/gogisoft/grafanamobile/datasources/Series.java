package com.gogisoft.grafanamobile.datasources;

import android.graphics.Point;
import java.util.List;


public class Series {
    private List<Point> points;

    public Series(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
