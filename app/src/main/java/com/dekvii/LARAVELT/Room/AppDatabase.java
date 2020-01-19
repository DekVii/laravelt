package com.dekvii.LARAVELT.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dekvii.LARAVELT.Model.Account;

@Database(entities = {Account.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase db(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "My Beauty").allowMainThreadQueries().build();
    }

    public abstract AccountRoom accountRoom();
}
