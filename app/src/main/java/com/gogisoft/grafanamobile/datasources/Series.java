package com.gogisoft.grafanamobile.datasources;

import java.util.List;


public class Series {
    public static class Point {
        public double value;
        public long time;

        public Point(double value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    private List<Series.Point> points;

    public Series(List<Series.Point> points) {
        this.points = points;
    }

    public List<Series.Point> getPoints() {
        return points;
    }
}
