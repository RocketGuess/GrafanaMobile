
package com.gogisoft.grafanamobile.api_client.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("collapse")
    @Expose
    private Boolean collapse;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("panels")
    @Expose
    private List<Panel> panels = null;
    @SerializedName("repeat")
    @Expose
    private Object repeat;
    @SerializedName("repeatIteration")
    @Expose
    private Object repeatIteration;
    @SerializedName("repeatRowId")
    @Expose
    private Object repeatRowId;
    @SerializedName("showTitle")
    @Expose
    private Boolean showTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleSize")
    @Expose
    private String titleSize;

    public Boolean getCollapse() {
        return collapse;
    }

    public void setCollapse(Boolean collapse) {
        this.collapse = collapse;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<Panel> getPanels() {
        return panels;
    }

    public void setPanels(List<Panel> panels) {
        this.panels = panels;
    }

    public Object getRepeat() {
        return repeat;
    }

    public void setRepeat(Object repeat) {
        this.repeat = repeat;
    }

    public Object getRepeatIteration() {
        return repeatIteration;
    }

    public void setRepeatIteration(Object repeatIteration) {
        this.repeatIteration = repeatIteration;
    }

    public Object getRepeatRowId() {
        return repeatRowId;
    }

    public void setRepeatRowId(Object repeatRowId) {
        this.repeatRowId = repeatRowId;
    }

    public Boolean getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(String titleSize) {
        this.titleSize = titleSize;
    }

}
