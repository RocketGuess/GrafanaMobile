
package com.gogisoft.grafanamobile.api_client.models.prometheus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrometheusMetric {

    @SerializedName("cpu")
    @Expose
    private String cpu;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

}
