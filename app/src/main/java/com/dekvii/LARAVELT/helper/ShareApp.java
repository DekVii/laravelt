package com.dekvii.LARAVELT.helper;

import android.content.Context;
import android.content.Intent;

public class ShareApp {
    public static void share (Context context){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Aplikasi Amikon Two ada Di Playstore,Jangan Lupa Di Download di " + "https://play.google.com/store/apps/detail?id=com.WhatsApp+");
        context.startActivity(Intent.createChooser(intent, "Bagikan Dengan "));
    }
}
