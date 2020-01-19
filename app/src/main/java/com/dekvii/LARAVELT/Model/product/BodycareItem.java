package com.dekvii.LARAVELT.Model.product;

import com.google.gson.annotations.SerializedName;

public class BodycareItem{

	@SerializedName("product")
	private String product;

	@SerializedName("harga")
	private int harga;

	@SerializedName("picture")
	private String picture;

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	@Override
 	public String toString(){
		return 
			"BodycareItem{" + 
			"product = '" + product + '\'' + 
			",harga = '" + harga + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}