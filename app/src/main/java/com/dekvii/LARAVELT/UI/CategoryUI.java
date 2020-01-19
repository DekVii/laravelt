package com.dekvii.LARAVELT.UI;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.API.ClientService;
import com.dekvii.LARAVELT.API.RetrofitClient;
import com.dekvii.LARAVELT.Adapter.CategoryAdapter;
import com.dekvii.LARAVELT.Model.Category;
import com.dekvii.LARAVELT.Model.product.Product;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Integer> imagelist = new ArrayList<>();
    private List<Category> category = new ArrayList<>();
    private Retrofit retrofit;
    private ClientService client;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryAdapter = new CategoryAdapter(getActivity());
        retrofit = RetrofitClient.connect();
        client = retrofit.create(ClientService.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.ui_category, container, false);

        findView(view);
        initView();
        return view;
    }

    private void findView(ViewGroup view) {
        recyclerView = view.findViewById(R.id.recycler_category);
    }

    private void initView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        requestApi();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private void requestApi() {
        final Call<Product> request = client.getProduct();
        request.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                for (int i = 0; i < response.body().getCategory().size(); i++ ) {
                    if (i == 0) {
                        category.add(new Category(response.body().getCategory().get(i).getIkon(), "Skincare"));
                    } else if (i == 1) {
                        category.add(new Category(response.body().getCategory().get(i).getIkon(), "Haircare"));
                    } else if (i == 2) {
                        category.add(new Category(response.body().getCategory().get(i).getIkon(), "Bodycare"));
                    } else {
                        category.add(new Category(response.body().getCategory().get(i).getIkon(), "Makeup"));
                    }
                }
                categoryAdapter.setData(category);

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(getActivity(), "gagal request API", Toast.LENGTH_SHORT).show();
            }

        });

    }
}