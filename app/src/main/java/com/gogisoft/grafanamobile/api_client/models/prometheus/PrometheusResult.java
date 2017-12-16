
package com.gogisoft.grafanamobile.api_client.models.prometheus;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrometheusResult {

    @SerializedName("metric")
    @Expose
    private PrometheusMetric metric;
    @SerializedName("values")
    @Expose
    private List<List<Float>> values = null;

    public PrometheusMetric getMetric() {
        return metric;
    }

    public void setMetric(PrometheusMetric metric) {
        this.metric = metric;
    }

    public List<List<Float>> getValues() {
        return values;
    }

    public void setValues(List<List<Float>> values) {
        this.values = values;
    }

}
