package com.org.organisation.dto;

import java.util.Objects;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.NotEmpty;

public class LoginDto {
	@NotEmpty
	@UniqueElements
	private String userName;
	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDto other = (LoginDto) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
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
	@NotEmpty
	private String password;

}
