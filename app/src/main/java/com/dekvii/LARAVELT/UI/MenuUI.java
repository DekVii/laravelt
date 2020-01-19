package com.dekvii.LARAVELT.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.API.ClientService;
import com.dekvii.LARAVELT.API.RetrofitClient;
import com.dekvii.LARAVELT.Adapter.Product.BodycareAdapter;
import com.dekvii.LARAVELT.Adapter.Product.HaircareAdapter;
import com.dekvii.LARAVELT.Adapter.Product.MakeupAdapter;
import com.dekvii.LARAVELT.Adapter.Product.SkincareAdapter;
import com.dekvii.LARAVELT.Adapter.MenuAdapter;
import com.dekvii.LARAVELT.Model.product.CategoryItem;
import com.dekvii.LARAVELT.Model.product.Product;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MenuUI extends Fragment {

    private MenuAdapter menuAdapter;
    private SkincareAdapter skincareAdapter;
    private BodycareAdapter bodycareAdapter;
    private HaircareAdapter haircareAdapter;
    private MakeupAdapter makeupAdapter;
    private List<Integer> imagesList = new ArrayList<>();
    private RecyclerView rv;
    private RecyclerView rvSkincare, rvHairCare, rvBodycare, rvMakeup;
    private Retrofit retrofit;
    private ClientService service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuAdapter = new MenuAdapter(getActivity());
        skincareAdapter = new SkincareAdapter(getActivity());
        bodycareAdapter = new BodycareAdapter(getActivity());
        haircareAdapter = new HaircareAdapter(getActivity());
        makeupAdapter = new MakeupAdapter(getActivity());
        retrofit = RetrofitClient.connect();
        service = retrofit.create(ClientService.class);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.ui_menu, container, false);
        initComponent();
        findView(rootView);
        initView();
        return rootView;
    }


    private void initComponent() {
        imagesList.add(R.drawable.promo1);
        imagesList.add(R.drawable.promo2);
        imagesList.add(R.drawable.promo4);
    }


    private void initView() {
        rv.setHasFixedSize(true);
        rv.setAdapter(menuAdapter);

        rvSkincare.setHasFixedSize(true);
        rvSkincare.setAdapter(skincareAdapter);
//        rvSkincare.setOnClickListener(MenuUI.this);

        rvHairCare.setHasFixedSize(true);
        rvHairCare.setAdapter(haircareAdapter);

        rvBodycare.setHasFixedSize(true);
        rvBodycare.setAdapter(bodycareAdapter);

        rvMakeup.setHasFixedSize(true);
        rvMakeup.setAdapter(makeupAdapter);


    }

    private void findView(ViewGroup rootView) {
        rv = rootView.findViewById(R.id.rv_promo);
        rvSkincare = rootView.findViewById(R.id.grid_product);
        rvHairCare = rootView.findViewById(R.id.grid_haircare);
        rvBodycare = rootView.findViewById(R.id.grid_bodycare);
        rvMakeup = rootView.findViewById(R.id.grid_makeup);


    }

    @Override
    public void onResume() {
        super.onResume();
        menuAdapter.setData(imagesList);
        requestApi();
    }

    private void requestApi() {

        final Call<Product> request = service.getProduct();
        request.enqueue(new Callback<Product>() {

            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {

                for (CategoryItem item : response.body().getCategory()) {
                    if (skincareAdapter.getItemCount() == 0
                            && item.getSkincare() != null) {
                        skincareAdapter.setData(item.getSkincare());
                    } else if(bodycareAdapter.getItemCount() == 0
                        && item.getBodycare() != null){
                        bodycareAdapter.setData(item.getBodycare());
                    }else if(haircareAdapter.getItemCount() == 0
                            && item.getHaircare() != null) {
                        haircareAdapter.setData(item.getHaircare());
                    }else if(makeupAdapter.getItemCount() == 0
                            && item.getMakeup() != null) {
                        makeupAdapter.setData(item.getMakeup());
                    }

                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(getActivity(), "gagal request API", Toast.LENGTH_SHORT).show();
            }

        });
    }

//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent detailIntent = new Intent(this, DetailProductActivity.class);
//        CategoryItem clickedItem = skincareAdapter.get(position);
//    }
}