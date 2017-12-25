
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Target {
    @SerializedName("expr")
    @Expose
    private String expr;
    @SerializedName("legendFormat")
    @Expose
    private String legendFormat;
    @SerializedName("refId")
    @Expose
    private String refId;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("intervalFactor")
    @Expose
    private Integer intervalFactor;

    public String getRefId() {
        return refId;
    }

    public String getTarget() {
        return target;
    }

    public String getExpr() {
        return expr;
    }

    public String getLegendFormat() {
        return legendFormat;
    }

    public Integer getIntervalFactor() {
        if(intervalFactor == null){
            return 1;
        } else {
            return intervalFactor;
        }
    }

    public Integer getStepByRange(int range) {
        int step = range / ( 900 / getIntervalFactor());

        if(step > 0) {
            return step;
        } else {
            return 1;
        }
    }

    public Integer getPoints() {
        return 100;
    }
}
