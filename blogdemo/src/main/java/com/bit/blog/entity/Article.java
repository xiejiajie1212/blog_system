package com.bit.blog.entity;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date createtime;
    private String userAccout;

    public String getUserAccout() {
        return userAccout;
    }

    public void setUserAccout(String userAccout) {
        this.userAccout = userAccout;
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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + ", userId=" + userId + ", createtime=" + createtime + '}';
    }
}
