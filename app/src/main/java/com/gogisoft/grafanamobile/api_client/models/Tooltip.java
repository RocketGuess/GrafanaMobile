
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tooltip {

    @SerializedName("query_as_alias")
    @Expose
    private Boolean queryAsAlias;
    @SerializedName("shared")
    @Expose
    private Boolean shared;
    @SerializedName("sort")
    @Expose
    private Integer sort;
    @SerializedName("value_type")
    @Expose
    private String valueType;

    public Boolean getQueryAsAlias() {
        return queryAsAlias;
    }

    public void setQueryAsAlias(Boolean queryAsAlias) {
        this.queryAsAlias = queryAsAlias;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

}
