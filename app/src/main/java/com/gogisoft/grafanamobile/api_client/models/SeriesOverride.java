
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeriesOverride {

    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("fill")
    @Expose
    private Integer fill;
    @SerializedName("lines")
    @Expose
    private Boolean lines;
    @SerializedName("yaxis")
    @Expose
    private Integer yaxis;
    @SerializedName("zindex")
    @Expose
    private Integer zindex;
    @SerializedName("pointradius")
    @Expose
    private Integer pointradius;
    @SerializedName("points")
    @Expose
    private Boolean points;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getFill() {
        return fill;
    }

    public void setFill(Integer fill) {
        this.fill = fill;
    }

    public Boolean getLines() {
        return lines;
    }

    public void setLines(Boolean lines) {
        this.lines = lines;
    }

    public Integer getYaxis() {
        return yaxis;
    }

    public void setYaxis(Integer yaxis) {
        this.yaxis = yaxis;
    }

    public Integer getZindex() {
        return zindex;
    }

    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }

    public Integer getPointradius() {
        return pointradius;
    }

    public void setPointradius(Integer pointradius) {
        this.pointradius = pointradius;
    }

    public Boolean getPoints() {
        return points;
    }

    public void setPoints(Boolean points) {
        this.points = points;
    }

}
