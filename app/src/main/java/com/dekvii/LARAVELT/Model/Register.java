package com.dekvii.LARAVELT.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Register{

	@SerializedName("register")
	private List<RegisterItem> register;

	public void setRegister(List<RegisterItem> register){
		this.register = register;
	}

	public List<RegisterItem> getRegister(){
		return register;
	}

	@Override
 	public String toString(){
		return 
			"Register{" + 
			"register = '" + register + '\'' + 
			"}";
		}
}