
package com.gogisoft.grafanamobile.api_client.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Panel {

    @SerializedName("editable")
    @Expose
    private Boolean editable;
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("headings")
    @Expose
    private Boolean headings;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("recent")
    @Expose
    private Boolean recent;
    @SerializedName("search")
    @Expose
    private Boolean search;
    @SerializedName("span")
    @Expose
    private Integer span;
    @SerializedName("starred")
    @Expose
    private Boolean starred;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("transparent")
    @Expose
    private Boolean transparent;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("aliasColors")
    @Expose
    private Map<String, String> aliasColors;
    @SerializedName("annotate")
    @Expose
    private Annotate annotate;
    @SerializedName("bars")
    @Expose
    private Boolean bars;
    @SerializedName("dashLength")
    @Expose
    private Integer dashLength;
    @SerializedName("dashes")
    @Expose
    private Boolean dashes;
    @SerializedName("datasource")
    @Expose
    private String datasource;
    @SerializedName("fill")
    @Expose
    private Integer fill;
    @SerializedName("grid")
    @Expose
    private Grid grid;
    @SerializedName("interactive")
    @Expose
    private Boolean interactive;
    @SerializedName("legend")
    @Expose
    private Legend legend;
    @SerializedName("legend_counts")
    @Expose
    private Boolean legendCounts;
    @SerializedName("lines")
    @Expose
    private Boolean lines;
    @SerializedName("linewidth")
    @Expose
    private Integer linewidth;
    @SerializedName("nullPointMode")
    @Expose
    private String nullPointMode;
    @SerializedName("options")
    @Expose
    private Boolean options;
    @SerializedName("percentage")
    @Expose
    private Boolean percentage;
    @SerializedName("pointradius")
    @Expose
    private Integer pointradius;
    @SerializedName("points")
    @Expose
    private Boolean points;
    @SerializedName("renderer")
    @Expose
    private String renderer;
    @SerializedName("resolution")
    @Expose
    private Integer resolution;
    @SerializedName("scale")
    @Expose
    private Integer scale;
    @SerializedName("seriesOverrides")
    @Expose
    private List<SeriesOverride> seriesOverrides = null;
    @SerializedName("spaceLength")
    @Expose
    private Integer spaceLength;
    @SerializedName("spyable")
    @Expose
    private Boolean spyable;
    @SerializedName("stack")
    @Expose
    private Boolean stack;
    @SerializedName("steppedLine")
    @Expose
    private Boolean steppedLine;
    @SerializedName("targets")
    @Expose
    private List<Target> targets = null;
    // @SerializedName("thresholds")
    // @Expose
    // private List<Object> thresholds = null;
    @SerializedName("timeFrom")
    @Expose
    private Object timeFrom;
    @SerializedName("timeShift")
    @Expose
    private Object timeShift;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("tooltip")
    @Expose
    private Tooltip tooltip;
    @SerializedName("xaxis")
    @Expose
    private Xaxis xaxis;
    @SerializedName("yaxes")
    @Expose
    private List<Yaxis> yaxes = null;
    @SerializedName("zerofill")
    @Expose
    private Boolean zerofill;
    @SerializedName("description")
    @Expose
    private String description;

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Boolean getHeadings() {
        return headings;
    }

    public void setHeadings(Boolean headings) {
        this.headings = headings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getRecent() {
        return recent;
    }

    public void setRecent(Boolean recent) {
        this.recent = recent;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    public Integer getSpan() {
        return span;
    }

    public void setSpan(Integer span) {
        this.span = span;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getTransparent() {
        return transparent;
    }

    public void setTransparent(Boolean transparent) {
        this.transparent = transparent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getAliasColors() {
        return aliasColors;
    }

    public void setAliasColors(Map<String, String> aliasColors) {
        this.aliasColors = aliasColors;
    }

    public Annotate getAnnotate() {
        return annotate;
    }

    public void setAnnotate(Annotate annotate) {
        this.annotate = annotate;
    }

    public Boolean getBars() {
        return bars;
    }

    public void setBars(Boolean bars) {
        this.bars = bars;
    }

    public Integer getDashLength() {
        return dashLength;
    }

    public void setDashLength(Integer dashLength) {
        this.dashLength = dashLength;
    }

    public Boolean getDashes() {
        return dashes;
    }

    public void setDashes(Boolean dashes) {
        this.dashes = dashes;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public Integer getFill() {
        return fill;
    }

    public void setFill(Integer fill) {
        this.fill = fill;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Boolean getInteractive() {
        return interactive;
    }

    public void setInteractive(Boolean interactive) {
        this.interactive = interactive;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public Boolean getLegendCounts() {
        return legendCounts;
    }

    public void setLegendCounts(Boolean legendCounts) {
        this.legendCounts = legendCounts;
    }

    public Boolean getLines() {
        return lines;
    }

    public void setLines(Boolean lines) {
        this.lines = lines;
    }

    public Integer getLinewidth() {
        return linewidth;
    }

    public void setLinewidth(Integer linewidth) {
        this.linewidth = linewidth;
    }

    public String getNullPointMode() {
        return nullPointMode;
    }

    public void setNullPointMode(String nullPointMode) {
        this.nullPointMode = nullPointMode;
    }

    public Boolean getOptions() {
        return options;
    }

    public void setOptions(Boolean options) {
        this.options = options;
    }

    public Boolean getPercentage() {
        return percentage;
    }

    public void setPercentage(Boolean percentage) {
        this.percentage = percentage;
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

    public String getRenderer() {
        return renderer;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public Integer getResolution() {
        return resolution;
    }

    public void setResolution(Integer resolution) {
        this.resolution = resolution;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public List<SeriesOverride> getSeriesOverrides() {
        return seriesOverrides;
    }

    public void setSeriesOverrides(List<SeriesOverride> seriesOverrides) {
        this.seriesOverrides = seriesOverrides;
    }

    public Integer getSpaceLength() {
        return spaceLength;
    }

    public void setSpaceLength(Integer spaceLength) {
        this.spaceLength = spaceLength;
    }

    public Boolean getSpyable() {
        return spyable;
    }

    public void setSpyable(Boolean spyable) {
        this.spyable = spyable;
    }

    public Boolean getStack() {
        return stack;
    }

    public void setStack(Boolean stack) {
        this.stack = stack;
    }

    public Boolean getSteppedLine() {
        return steppedLine;
    }

    public void setSteppedLine(Boolean steppedLine) {
        this.steppedLine = steppedLine;
    }

    public List<Target> getTargets() {
        if(targets != null) {
            return targets;
        } else {
            return new ArrayList<Target>();
        }
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    // public List<Object> getThresholds() {
    //     return thresholds;
    // }

    // public void setThresholds(List<Object> thresholds) {
    //     this.thresholds = thresholds;
    // }

    public Object getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Object timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Object getTimeShift() {
        return timeShift;
    }

    public void setTimeShift(Object timeShift) {
        this.timeShift = timeShift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public Xaxis getXaxis() {
        return xaxis;
    }

    public void setXaxis(Xaxis xaxis) {
        this.xaxis = xaxis;
    }

    public List<Yaxis> getYaxes() {
        return yaxes;
    }

    public void setYaxes(List<Yaxis> yaxes) {
        this.yaxes = yaxes;
    }

    public Boolean getZerofill() {
        return zerofill;
    }

    public void setZerofill(Boolean zerofill) {
        this.zerofill = zerofill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
