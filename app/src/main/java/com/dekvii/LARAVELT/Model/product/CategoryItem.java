package com.dekvii.LARAVELT.Model.product;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoryItem{

	@SerializedName("ikon")
	private String ikon;

	@SerializedName("makeup")
	private List<MakeupItem> makeup;

	@SerializedName("bodycare")
	private List<BodycareItem> bodycare;

	@SerializedName("haircare")
	private List<HaircareItem> haircare;

	@SerializedName("skincare")
	private List<SkincareItem> skincare;

	public void setIkon(String ikon){
		this.ikon = ikon;
	}

	public String getIkon(){
		return ikon;
	}

	public void setMakeup(List<MakeupItem> makeup){
		this.makeup = makeup;
	}

	public List<MakeupItem> getMakeup(){
		return makeup;
	}

	public void setBodycare(List<BodycareItem> bodycare){
		this.bodycare = bodycare;
	}

	public List<BodycareItem> getBodycare(){
		return bodycare;
	}

	public void setHaircare(List<HaircareItem> haircare){
		this.haircare = haircare;
	}

	public List<HaircareItem> getHaircare(){
		return haircare;
	}

	public void setSkincare(List<SkincareItem> skincare){
		this.skincare = skincare;
	}

	public List<SkincareItem> getSkincare(){
		return skincare;
	}

	@Override
 	public String toString(){
		return 
			"CategoryItem{" + 
			"ikon = '" + ikon + '\'' + 
			",makeup = '" + makeup + '\'' + 
			",bodycare = '" + bodycare + '\'' + 
			",haircare = '" + haircare + '\'' + 
			",skincare = '" + skincare + '\'' + 
			"}";
		}
}