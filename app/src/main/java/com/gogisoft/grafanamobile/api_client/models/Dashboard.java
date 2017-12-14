
package com.gogisoft.grafanamobile.api_client.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dashboard {

    @SerializedName("annotations")
    @Expose
    private Annotations annotations;
    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("gnetId")
    @Expose
    private Object gnetId;
    @SerializedName("graphTooltip")
    @Expose
    private Integer graphTooltip;
    @SerializedName("hideControls")
    @Expose
    private Boolean hideControls;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("refresh")
    @Expose
    private Boolean refresh;
    @SerializedName("rows")
    @Expose
    private List<Row> rows = null;
    @SerializedName("schemaVersion")
    @Expose
    private Integer schemaVersion;
    @SerializedName("style")
    @Expose
    private String style;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("templating")
    @Expose
    private Templating templating;
    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("timepicker")
    @Expose
    private Timepicker timepicker;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("version")
    @Expose
    private Integer version;

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Object getGnetId() {
        return gnetId;
    }

    public void setGnetId(Object gnetId) {
        this.gnetId = gnetId;
    }

    public Integer getGraphTooltip() {
        return graphTooltip;
    }

    public void setGraphTooltip(Integer graphTooltip) {
        this.graphTooltip = graphTooltip;
    }

    public Boolean getHideControls() {
        return hideControls;
    }

    public void setHideControls(Boolean hideControls) {
        this.hideControls = hideControls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public Boolean getRefresh() {
        return refresh;
    }

    public void setRefresh(Boolean refresh) {
        this.refresh = refresh;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public Integer getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(Integer schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Templating getTemplating() {
        return templating;
    }

    public void setTemplating(Templating templating) {
        this.templating = templating;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Timepicker getTimepicker() {
        return timepicker;
    }

    public void setTimepicker(Timepicker timepicker) {
        this.timepicker = timepicker;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
