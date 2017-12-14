
package com.gogisoft.grafanamobile.api_client.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timepicker {

    @SerializedName("collapse")
    @Expose
    private Boolean collapse;
    @SerializedName("enable")
    @Expose
    private Boolean enable;
    @SerializedName("notice")
    @Expose
    private Boolean notice;
    @SerializedName("now")
    @Expose
    private Boolean now;
    @SerializedName("refresh_intervals")
    @Expose
    private List<String> refreshIntervals = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("time_options")
    @Expose
    private List<String> timeOptions = null;
    @SerializedName("type")
    @Expose
    private String type;

    public Boolean getCollapse() {
        return collapse;
    }

    public void setCollapse(Boolean collapse) {
        this.collapse = collapse;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getNotice() {
        return notice;
    }

    public void setNotice(Boolean notice) {
        this.notice = notice;
    }

    public Boolean getNow() {
        return now;
    }

    public void setNow(Boolean now) {
        this.now = now;
    }

    public List<String> getRefreshIntervals() {
        return refreshIntervals;
    }

    public void setRefreshIntervals(List<String> refreshIntervals) {
        this.refreshIntervals = refreshIntervals;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTimeOptions() {
        return timeOptions;
    }

    public void setTimeOptions(List<String> timeOptions) {
        this.timeOptions = timeOptions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
