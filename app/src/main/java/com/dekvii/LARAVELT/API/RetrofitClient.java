package com.dekvii.LARAVELT.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String URL = "http://laravelt.000webhostapp.com//api/";

    public static Retrofit connect (){
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
