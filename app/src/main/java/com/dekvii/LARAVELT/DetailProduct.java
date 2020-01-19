package com.dekvii.LARAVELT.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.Adapter.CartAdapter;
import com.dekvii.LARAVELT.Model.Cart;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

public class CartUI<Cart> extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<Cart> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_cart, container, false);
        recyclerView = view.findViewById(R.id.recycler_cart);
        recyclerView.setAdapter(cartAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(llm);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), );
        startIntentSenderForResult(intent,30);
    }

    private void startIntentSenderForResult(Intent intent, int i) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cart cart = list.get(position);
        Toast.makeText(getContext(), cart.img(), Toast.LENGTH_SHORT).show();

    }
}