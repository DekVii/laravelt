package com.dekvii.LARAVELT.Model;


public class Category {
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryTittle() {
        return categoryTittle;
    }

    public void setCategoryTittle(String categoryTittle) {
        this.categoryTittle = categoryTittle;
    }

    public Category(String image, String categoryTittle) {
        this.image = image;
        this.categoryTittle = categoryTittle;
    }

    private String image;
    private String categoryTittle;



}
