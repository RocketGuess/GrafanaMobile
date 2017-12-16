package com.gogisoft.grafanamobile.datasources;

import java.util.ArrayList;
import java.util.List;

import com.gogisoft.grafanamobile.panels.TargetWrapper;

public class Datasource {
    private String name;

    public Datasource(String name) {
        this.name = name;
    }

    public List<Series> query(TargetWrapper target) {
        List<Series> series = new ArrayList<Series>();
        switch (target.getTargetType()) {
            default: {
                return series;
            }
        }
    }
}
