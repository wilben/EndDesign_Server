package com.gem.hsx.bean;

import java.io.Serializable;

/**
 * 设计师实体
 * 
 * @author wilben
 * 
 */

@SuppressWarnings("serial")
public class Designer implements Serializable{

	private String username; // 用户名
	private String password; // 密码
	private String sex; // 性别
	private String age; // 年龄
	private int role; // 角色
	private String realname; // 真实姓名
	private String avatar; // 头像
	private String concept; // 设计理念
	private String motto; // 人生格言
	private String style; // 风格
	private String work; // 作品
	private String period; // 从业时间
	private String area; // 服务地区

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

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

	public Designer(String username, String password, String sex,
			String realname, String age, String avatar, int role,
			String concept, String motto, String style, String work,
			String period, String area) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.realname = realname;
		this.avatar = avatar;
		this.role = role;
		this.concept = concept;
		this.motto = motto;
		this.style = style;
		this.work = work;
		this.period = period;
		this.area = area;
	}

	public Designer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
