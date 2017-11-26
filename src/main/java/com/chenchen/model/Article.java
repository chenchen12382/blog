package com.chenchen.model;

import com.chenchen.base.BaseModel;

/**
 * Created by Administrator on 2017/11/26.
 */
public class Article extends BaseModel{

    private String title;
    private String intro;
    private String content;
    private String typeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
