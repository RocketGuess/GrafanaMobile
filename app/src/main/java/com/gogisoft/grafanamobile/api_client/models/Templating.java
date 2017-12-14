
package com.gogisoft.grafanamobile.api_client.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Templating {

    @SerializedName("enable")
    @Expose
    private Boolean enable;
    @SerializedName("list")
    @Expose
    private List<Object> list = null;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

}
