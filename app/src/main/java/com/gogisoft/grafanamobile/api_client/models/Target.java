
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Target {

    // @SerializedName("hide")
    // @Expose
    // private Boolean hide;
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

}
