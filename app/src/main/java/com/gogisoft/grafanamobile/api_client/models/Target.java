
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Target {

    // @SerializedName("hide")
    // @Expose
    // private Boolean hide;
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

    // public Boolean getHide() {
    //     return hide;
    // }

    // public void setHide(Boolean hide) {
    //     this.hide = hide;
    // }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String getLegendFormat() {
        return legendFormat;
    }

    public void setLegendFormat(String legendFormat) {
        this.legendFormat = legendFormat;
    }
}
