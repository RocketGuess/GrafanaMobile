package com.gogisoft.grafanamobile.datasources;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Color;

import java.util.Date;
import java.util.List;


public class Series {
    public static class Point {
        public Double value;
        public Double time;

        public Point(Double value, Double time) {
            this.value = value;
            this.time = time;
        }
    }

    private List<Series.Point> points;
    private Map<String, String> tags;
    private int color;
    private String legendFormat;


    public Series(List<Series.Point> points, Map<String, String> tags, String legendFormat) {
        this.points = points;
        this.tags = tags;
        this.color = Color.GREEN;
        this.legendFormat = legendFormat;
    }

    public List<Series.Point> getPoints() {
        return points;
    }

    public String getName() {
        String input = legendFormat;

        Pattern p = Pattern.compile("\\{\\{.*\\}\\}");
        Matcher m = p.matcher(legendFormat);

        while (m.find()) {
            String group = m.group()
                .replaceAll("\\{\\{", "")
                .replaceAll("\\}\\}", "")
                .replaceAll(" ", "");

            String value = "undefined";
            if(this.tags.containsKey(group)) {
                value = this.tags.get(group);
            }

            input = input.replaceAll("\\{\\{[ ]*"+ group +"[ ]*\\}\\}", value);
        }

        return input;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
