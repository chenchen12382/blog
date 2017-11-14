package com.chenchen.vo;

import java.io.Serializable;

/**
 * Created by Tony on 2016/8/22.
 */
@SuppressWarnings("serial")
public class UserLoginIdentity implements Serializable {
    private String userIdString; // 将userId加密
    private String userName;
    private String realName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserIdString() {
        return userIdString;
    }

    public void setUserIdString(String userIdString) {
        this.userIdString = userIdString;
    }

}
