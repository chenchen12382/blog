package com.chenchen.model;



import com.chenchen.base.BaseModel;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class User extends BaseModel {
	
	private String userName; //用户名
	private String password; //密码
	private String nickName; //昵称
	private String mood;  //签名
	private String img;  //头像
//	private Integer[] roleIds;
//	private List<RoleVO> roles;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
