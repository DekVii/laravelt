package com.dekvii.LARAVELT.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.Detail.EditAccountActivity;
import com.dekvii.LARAVELT.Adapter.AccountAdapter;
import com.dekvii.LARAVELT.Model.Account;
import com.dekvii.LARAVELT.R;
import com.dekvii.LARAVELT.Room.AccountRoom;
import com.dekvii.LARAVELT.Room.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AccountUI extends Fragment {
    private RecyclerView recyclerView;
    private AccountAdapter accountAdapter;
    private List<Account> list = new ArrayList<>();
    private AccountRoom accountRoom;
    FloatingActionButton floatingActionButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountRoom = AppDatabase.db(getContext()).accountRoom();
        list = accountRoom.selectAll();
        accountAdapter = new AccountAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_account, container, false);
        recyclerView = view.findViewById(R.id.recycler_account);
        recyclerView.setAdapter(accountAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
//        fab.setOnClickListener(this);
        return view;
    }

//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(getContext(), EditAccountActivity.class);
//        startActivityForResult(intent, 30);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Activity.RESULT_OK) {
            list.clear();
            list.addAll(accountRoom.selectAll());
            accountAdapter.notifyDataSetChanged();
        }
    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//        Account account = list.get(position);
//        Toast.makeText(getContext(), account.getName(), Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(getContext(), EditAccountActivity.class);
//        intent.putExtra("id", account.getId());
//        startActivityForResult(intent, 50);
//
//    }
}