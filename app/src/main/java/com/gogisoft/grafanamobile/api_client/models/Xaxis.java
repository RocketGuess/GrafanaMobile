
package com.gogisoft.grafanamobile.api_client.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xaxis {

    @SerializedName("buckets")
    @Expose
    private Object buckets;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("show")
    @Expose
    private Boolean show;
    @SerializedName("values")
    @Expose
    private List<Object> values = null;

    public Object getBuckets() {
        return buckets;
    }

    public void setBuckets(Object buckets) {
        this.buckets = buckets;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

}
