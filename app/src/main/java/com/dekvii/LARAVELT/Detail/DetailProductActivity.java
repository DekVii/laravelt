package com.dekvii.LARAVELT.Detail;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.API.ClientService;
import com.dekvii.LARAVELT.API.RetrofitClient;
import com.dekvii.LARAVELT.Adapter.MenuAdapter;
import com.dekvii.LARAVELT.Adapter.Product.BodycareAdapter;
import com.dekvii.LARAVELT.Adapter.Product.HaircareAdapter;
import com.dekvii.LARAVELT.Adapter.Product.MakeupAdapter;
import com.dekvii.LARAVELT.Adapter.Product.SkincareAdapter;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class DetailProductActivity  extends Activity {
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_product);

//        menuAdapter = new MenuAdapter(getActivity());
//        skincareAdapter = new SkincareAdapter(getActivity());
//        bodycareAdapter = new BodycareAdapter(getActivity());
//        haircareAdapter = new HaircareAdapter(getActivity());
//        makeupAdapter = new MakeupAdapter(getActivity());
        retrofit = RetrofitClient.connect();
        service = retrofit.create(ClientService.class);
    }
}
