package com.gogisoft.grafanamobile.api_client.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardsListModel {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("uri")
@Expose
private String uri;
@SerializedName("type")
@Expose
private String type;
@SerializedName("tags")
@Expose
private List<String> tags = null;
@SerializedName("isStarred")
@Expose
private Boolean isStarred;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getUri() {
return uri;
}

public void setUri(String uri) {
this.uri = uri;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public List<String> getTags() {
return tags;
}

public void setTags(List<String> tags) {
this.tags = tags;
}

public Boolean getIsStarred() {
return isStarred;
}

public void setIsStarred(Boolean isStarred) {
this.isStarred = isStarred;
}

}
