package com.gogisoft.grafanamobile.datasources;

import java.util.Map;
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
    public Map<String, String> tags;

    public Series(List<Series.Point> points, Map<String, String> tags) {
        this.points = points;
        this.tags = tags;
    }

    public List<Series.Point> getPoints() {
        return points;
    }

    public String getName() {
        String str = "";

        for (Map.Entry<String, String> entry : this.tags.entrySet()) {
            str += entry.getKey() + ": " + entry.getValue() + " ";
        }

        return str;
    }
}
