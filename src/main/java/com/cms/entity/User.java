package com.cms.entity;

/**
 * Created by kzyuan on 2017/5/17.
 */
public class User {


    private long id;
    private String userName;
    private String passWord;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

