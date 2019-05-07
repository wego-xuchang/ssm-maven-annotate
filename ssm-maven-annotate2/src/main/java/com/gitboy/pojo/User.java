package com.gitboy.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	private String password;
	private int role;
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(int id, String username, String sex, Date birthday, String address, String password, int role) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", password=" + password + ", role=" + role + "]";
	}
	
}
