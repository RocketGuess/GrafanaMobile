
package com.gogisoft.grafanamobile.api_client.models.prometheus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrometheusQueryResponce {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private PrometheusData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PrometheusData getData() {
        return data;
    }

    public void setData(PrometheusData data) {
        this.data = data;
    }

}
