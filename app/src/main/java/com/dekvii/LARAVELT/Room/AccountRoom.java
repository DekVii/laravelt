package com.dekvii.LARAVELT.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dekvii.LARAVELT.Model.Account;

import java.util.List;

@Dao
public interface AccountRoom {

    @Query("SELECT * FROM account WHERE id = :id")
    Account select(int id);

    @Query("SELECT * FROM account")
    List<Account> selectAll();

    @Insert
    void insert(Account account);

    @Update
    void update( Account account);

    @Delete
    void delete(Account account);
}
