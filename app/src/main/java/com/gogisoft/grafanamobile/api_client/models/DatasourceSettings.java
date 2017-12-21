
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatasourceSettings {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

}
