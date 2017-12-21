package com.gogisoft.grafanamobile.api_client.models.graphite;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GraphiteQueryResponce {

    @SerializedName("datapoints")
    @Expose
    private List<List<Double>> datapoints = null;
    @SerializedName("target")
    @Expose
    private String target;

    public List<List<Double>> getDatapoints() {
        return datapoints;
    }

    public String getTarget() {
        return target;
    }
}
