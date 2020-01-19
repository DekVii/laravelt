package com.dekvii.LARAVELT.Model;

import com.google.gson.annotations.SerializedName;

public class RegisterItem{

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"RegisterItem{" + 
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}