package com.cms.entity;

/**
 * Created by ykz on 2017/4/5.
 */
public class DynamicParams {

    private String projectId;
    private String name;
    private String type;

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProjectId() {

        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
