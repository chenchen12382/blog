package com.chenchen.dto;

import com.chenchen.base.BaseQuery;

/**
 * Created by Administrator on 2017/12/13.
 */
public class IndexQuery extends BaseQuery {

    private String name;
    private String tag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
