
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Legend {

    @SerializedName("avg")
    @Expose
    private Boolean avg;
    @SerializedName("current")
    @Expose
    private Boolean current;
    @SerializedName("max")
    @Expose
    private Boolean max;
    @SerializedName("min")
    @Expose
    private Boolean min;
    @SerializedName("show")
    @Expose
    private Boolean show;
    @SerializedName("total")
    @Expose
    private Boolean total;
    @SerializedName("values")
    @Expose
    private Boolean values;
    @SerializedName("alignAsTable")
    @Expose
    private Boolean alignAsTable;
    @SerializedName("rightSide")
    @Expose
    private Boolean rightSide;
    @SerializedName("legendSideLastValue")
    @Expose
    private Boolean legendSideLastValue;

    public Boolean getAvg() {
        return avg;
    }

    public void setAvg(Boolean avg) {
        this.avg = avg;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Boolean getMax() {
        return max;
    }

    public void setMax(Boolean max) {
        this.max = max;
    }

    public Boolean getMin() {
        return min;
    }

    public void setMin(Boolean min) {
        this.min = min;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Boolean getTotal() {
        return total;
    }

    public void setTotal(Boolean total) {
        this.total = total;
    }

    public Boolean getValues() {
        return values;
    }

    public void setValues(Boolean values) {
        this.values = values;
    }

    public Boolean getAlignAsTable() {
        return alignAsTable;
    }

    public void setAlignAsTable(Boolean alignAsTable) {
        this.alignAsTable = alignAsTable;
    }

    public Boolean getRightSide() {
        return rightSide;
    }

    public void setRightSide(Boolean rightSide) {
        this.rightSide = rightSide;
    }

    public Boolean getLegendSideLastValue() {
        return legendSideLastValue;
    }

    public void setLegendSideLastValue(Boolean legendSideLastValue) {
        this.legendSideLastValue = legendSideLastValue;
    }

}
