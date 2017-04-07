package com.cms.entity;

import org.springframework.stereotype.Component;

/**
 * Created by ykz on 2017/4/5.
 */
@Component
public class WebConfig {
    private String resource;//静态资源文件
    private String context;//WEB应用上下文
    private String revision;//CSS、js版本号，防止缓存的问题

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getResource() {

        return resource;
    }

    public String getContext() {
        return context;
    }

    public String getRevision() {
        return revision;
    }
}
