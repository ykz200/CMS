package com.cms.entity;

import java.util.Date;


public class Article {
    private Integer id;

    private String title;

    private Date time;

    private String image;

    private String info;

    private String stats;

    private String mobileArticle;
    private String updateTime;

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTime() {

        return updateTime;
    }

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
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats == null ? null : stats.trim();
    }


    public void setMobileArticle(String mobileArticle) {
        this.mobileArticle = mobileArticle;
    }

    public String getMobileArticle() {

        return mobileArticle;
    }
}