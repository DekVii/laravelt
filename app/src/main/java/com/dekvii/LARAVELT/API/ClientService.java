package com.dekvii.LARAVELT.API;

import com.dekvii.LARAVELT.Model.product.Product;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientService {
    @FormUrlEncoded
    @POST("login.json")
    Call<ResponseBody> login(@Field("username") String username,
                             @Field("password") String password);

    @POST("register.json")
    Call<ResponseBody> register(@Field("username") String username,
                             @Field("email") String email,
                             @Field("password") String password);

    @POST("auth/logout")
    Call<ResponseBody> logout();

    @GET("laravelt.json")
    Call<Product> getProduct();
}

