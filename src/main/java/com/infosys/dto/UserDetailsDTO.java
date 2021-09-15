package com.infosys.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.infosys.entity.UserDetails;

public class UserDetailsDTO 
{
	@Pattern(regexp = "C100[\\d]{1,3}", message = "{message.id.property}")
	private String userId;
	private String password;
	@Size(min = 5, max = 30, message = "{message.name.property}")
	private String name;
	private String city;
	@Email(message = "{message.email.property}")
	private String email;
	@Pattern(regexp = "[\\d]{10}", message = "{message.phone.property}")
	private String phone;
	public UserDetailsDTO(String userId, String password, String name, String city, String email, String phone) {
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
		return "UserDetailsDTO [userId=" + userId + ", password=" + password + ", name=" + name + ", city=" + city
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	public UserDetails prepareUserEntity()
	{
		UserDetails user = new UserDetails();
		user.setUserId(this.userId);
		user.setPassword(this.password);
		user.setName(this.name);
		user.setEmail(this.email);
		user.setCity(this.city);
		user.setPhone(this.phone);
		
		return user;
	}
}
