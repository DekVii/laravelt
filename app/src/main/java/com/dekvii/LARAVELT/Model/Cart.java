package com.dekvii.LARAVELT.Model;

import androidx.room.PrimaryKey;

import com.dekvii.LARAVELT.Model.product.BodycareItem;
import com.dekvii.LARAVELT.Model.product.CategoryItem;
import com.dekvii.LARAVELT.Model.product.HaircareItem;
import com.dekvii.LARAVELT.Model.product.MakeupItem;
import com.dekvii.LARAVELT.Model.product.SkincareItem;

import java.util.List;

import retrofit2.http.Body;

public class Cart {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private com.dekvii.LARAVELT.Model.product.BodycareItem BodycareItem;
    private com.dekvii.LARAVELT.Model.product.CategoryItem CategoryItem;
    private com.dekvii.LARAVELT.Model.product.HaircareItem HaircareItem;
    private com.dekvii.LARAVELT.Model.product.MakeupItem MakeupItem;
    private com.dekvii.LARAVELT.Model.product.SkincareItem SkincareItem;
    private String Cart;

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getCart() {
        String Cart;
        return Cart;
    }

    public void setCart(String cartId) {
        this.Cart = Cart;
    }

    public BodycareItem getBodycareItem() {
        return BodycareItem;
    }

    public void setBodycareItem(BodycareItem bodycareItem) {
        this.BodycareItem = bodycareItem;
    }

    public CategoryItem getCategoryItem() {
        return CategoryItem;
    }

    public void setCategoryItem (CategoryItem categoryItem) {
        this.CategoryItem = categoryItem;
    }

    public HaircareItem getHaircareItem() {
        return HaircareItem;
    }

    public void setHaircareItem(HaircareItem haircareItem) {
        this.HaircareItem = haircareItem;
    }

    public MakeupItem getMakeupItem() {
        return MakeupItem;
    }

    public void setMakeupItem(MakeupItem makeupItem) {
        this.MakeupItem = makeupItem;
    }

    public SkincareItem getSkincareItem() {
        return SkincareItem;
    }

    public void setSkincareItem (SkincareItem skincareItem) {
        this.SkincareItem = skincareItem;
    }

    public List<Cart> getCartItem() {
        return Cart;
    }

    public void setCart(List<Cart> Cart) {
        this.Cart = Cart;
    }
    public List<Cart> getCart() {
        return Cart;
    }

    public void setCart(List<Cart> cart) {
        this.Cart = cart;
    }


}
