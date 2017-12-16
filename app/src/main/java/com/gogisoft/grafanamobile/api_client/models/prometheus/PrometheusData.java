
package com.gogisoft.grafanamobile.api_client.models.prometheus;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrometheusData {

    @SerializedName("resultType")
    @Expose
    private String resultType;
    @SerializedName("result")
    @Expose
    private List<PrometheusResult> result = null;

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public List<PrometheusResult> getResult() {
        return result;
    }

    public void setResult(List<PrometheusResult> result) {
        this.result = result;
    }

}
