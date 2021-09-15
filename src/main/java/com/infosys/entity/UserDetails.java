package com.infosys.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails 
{
	@Id
	private String userId;
	private String password;
	private String name;
	private String city;
	private String email;
	private String phone;
	
	public UserDetails()
	{
		
	}
	public UserDetails(String userId, String password, String name, String city, String email, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.city = city;
		this.email = email;
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", password=" + password + ", name=" + name + ", city=" + city
				+ ", email=" + email + ", phone=" + phone + "]";
	}
}
