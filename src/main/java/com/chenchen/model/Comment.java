package com.chenchen.model;

import com.chenchen.base.BaseModel;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/8.
 */
public class Comment extends BaseModel {

    private String nikeName;
    private String content;
    private Integer aid;

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}
