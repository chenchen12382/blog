package com.chenchen.model;



import com.chenchen.base.BaseModel;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class User extends BaseModel {
	
	private String userName;
	private String password;
	private String trueName;
	private String email;
	private String phone;
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
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public Integer[] getRoleIds() {
//		if (roles != null && roles.size() > 0) { // 给roleIds赋值
//			List<Integer> roleIds = new ArrayList<>();
//			for (RoleVO roleVO : roles) {
//				roleIds.add(roleVO.getId());
//			}
//			this.roleIds = roleIds.toArray(new Integer[]{});
//		}
//		return roleIds;
//	}
//	public void setRoleIds(Integer[] roleIds) {
//		this.roleIds = roleIds;
//	}
//	public List<RoleVO> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<RoleVO> roles) {
//		this.roles = roles;
//	}
	
}
