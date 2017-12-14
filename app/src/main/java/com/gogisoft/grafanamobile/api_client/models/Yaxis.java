
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Yaxis {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("logBase")
    @Expose
    private Integer logBase;
    @SerializedName("max")
    @Expose
    private Object max;
    @SerializedName("min")
    @Expose
    private Object min;
    @SerializedName("show")
    @Expose
    private Boolean show;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getLogBase() {
        return logBase;
    }

    public void setLogBase(Integer logBase) {
        this.logBase = logBase;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }

    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

}
