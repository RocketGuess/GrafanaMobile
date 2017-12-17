
package com.gogisoft.grafanamobile.api_client.models.prometheus;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrometheusResult {

    @SerializedName("metric")
    @Expose
    private Map<String, String> metric;
    @SerializedName("values")
    @Expose
    private List<List<Double>> values = null;

    public Map<String, String> getMetric() {
        return metric;
    }

    public void setMetric(Map<String, String> metric) {
        this.metric = metric;
    }

    public List<List<Double>> getValues() {
        return values;
    }

    public void setValues(List<List<Double>> values) {
        this.values = values;
    }

}
