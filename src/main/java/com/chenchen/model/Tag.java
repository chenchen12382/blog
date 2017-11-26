package com.chenchen.model;

import com.chenchen.base.BaseModel;

/**
 * Created by Administrator on 2017/11/26.
 */
public class Tag extends BaseModel {
    private String typeName;
    private Integer userId;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
