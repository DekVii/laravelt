package com.dekvii.LARAVELT.Model.product;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Product{

	@SerializedName("category")
	private List<CategoryItem> category;

	public void setCategory(List<CategoryItem> category){
		this.category = category;
	}

	public List<CategoryItem> getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Product{" + 
			"category = '" + category + '\'' + 
			"}";
		}
}