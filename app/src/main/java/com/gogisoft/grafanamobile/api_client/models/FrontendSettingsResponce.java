
package com.gogisoft.grafanamobile.api_client.models;

import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FrontendSettingsResponce {

    @SerializedName("datasources")
    @Expose
    private Map<String, DatasourceSettings> datasources;
    @SerializedName("defaultDatasource")
    @Expose
    private String defaultDatasource;

    public Map<String, DatasourceSettings> getDatasources() {
        return datasources;
    }

    public String getDefaultDatasource() {
        return defaultDatasource;
    }

}
