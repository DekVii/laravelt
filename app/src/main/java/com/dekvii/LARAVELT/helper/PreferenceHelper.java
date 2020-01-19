package com.dekvii.LARAVELT.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private static PreferenceHelper INSTANTCE;
    private SharedPreferences sP;

    private PreferenceHelper(Context context){
        sP = context.getApplicationContext().getSharedPreferences("simple.android.app", Context.MODE_PRIVATE);
    }

    public static PreferenceHelper getInstance(Context context){
        if (INSTANTCE == null){
            INSTANTCE = new PreferenceHelper(context);
        }
        return INSTANTCE;
    }

    public SharedPreferences Pref() {
        return sP;
    }

    public Boolean isLogin(){
        return sP.getBoolean("isLogin", false);
    }

    public void setLogin(Boolean isCall) {
        sP.edit().putBoolean("isCall", isCall).apply();
    }

    public void setName(String isName){
        sP.edit().putString("isName", isName).apply();
    }

    public String getName(){
        return sP.getString("isName", "");
    }

    public void setPass(String isPass){
        sP.edit().putString("isPass", isPass).apply();
    }

    public String getPass(){
        return sP.getString("isPass", " ");
    }


}
