package com.dekvii.LARAVELT.Detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dekvii.LARAVELT.Model.Account;
import com.dekvii.LARAVELT.R;
import com.dekvii.LARAVELT.Room.AccountRoom;
import com.dekvii.LARAVELT.Room.AppDatabase;

public class EditAccountActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName;
    EditText edtContact;
    EditText edtAddress;
    Button btnSave;
    Button btnReset;
    AccountRoom accountRoom;
    int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        edtName = findViewById(R.id.name_edit);
        edtContact = findViewById(R.id.contact_edit);
        edtAddress = findViewById(R.id.address_edit);
        btnSave = findViewById(R.id.account_save);
        btnSave.setOnClickListener(this);
        btnReset = findViewById(R.id.account_reset);

        accountRoom = AppDatabase.db(this).accountRoom();
        id = getIntent().getIntExtra("id", 0);
        if (id != 0) {
            Account account = accountRoom.select(id);
            edtName.setText(account.getName());
            edtContact.setText(account.getContact());
            edtAddress.setText(account.getAddress());
            btnSave.setText("Changed data");
            btnReset.setVisibility(View.VISIBLE);
            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Account account = accountRoom.select(id);
                    accountRoom.delete(account);
                    Intent result = new Intent();
                    setResult(Activity.RESULT_OK, result);
                    finish();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        Intent result = new Intent();
        Account account = new Account();
        if (id != 0) {
            account = accountRoom.select(id);
        }
        account.setName(edtName.getText().toString());
        account.setContact(edtContact.getText().toString());
        account.setAddress(edtAddress.getText().toString());

        if (id != 0) {
            accountRoom.update(account);
        }
        else {
            accountRoom.insert(account);
        }
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
