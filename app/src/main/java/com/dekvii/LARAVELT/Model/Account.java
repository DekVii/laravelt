package com.dekvii.LARAVELT.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Account {
    @PrimaryKey (autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "contact")
    private String contact;

    @ColumnInfo(name = "address")
    private String address;

    @Ignore
    public Account() {

    }

    public Account(String name, String contact, String address){
        this.name = name;
        this.contact = contact;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

