package com.gem.hsx.bean;

import java.io.Serializable;

/**
 * 用户实体
 * 
 * @author wilben
 * 
 */

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username; // 用户名
	private String password; // 密码
	private String sex; // 性别
	private String age; // 年龄
	private int role; // 角色
	private String realname; // 真实姓名
	private String avatar; // 头像
	private String style; // 风格

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User(String username, String password, String sex, String age,
			String avatar, String realname, int role, String style) {
		super();

		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.avatar = avatar;
		this.realname = realname;
		this.role = role;
		this.style = style;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
