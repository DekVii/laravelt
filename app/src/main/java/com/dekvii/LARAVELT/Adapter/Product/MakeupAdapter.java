package com.dekvii.LARAVELT.Adapter.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dekvii.LARAVELT.Model.product.MakeupItem;
import com.dekvii.LARAVELT.Model.product.SkincareItem;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

public class MakeupAdapter extends RecyclerView.Adapter<MakeupAdapter.MyViewHolder> {

    private Context context;
    private List<MakeupItem> list = new ArrayList<>();

    // method constructor
    public MakeupAdapter(Context context) {
        this.context = context;
    }

    // method untuk menset data berupa list
    public void setData(List<MakeupItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    // berfungsi untuk menentukan layout dari list item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid, parent, false));
    }

    // funsi untuk memasukan data ke dalam list item(class holder)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // data list di ambil berdasarkan posisinya
        MakeupItem item = list.get(position);
        // lalu di masukan ke dalam class holder melalui method bind
        holder.bind(item, position + 1);
        ImageView imageView = holder.imgProduct;

        Glide.with(context).load("http://laravelt.000webhostapp.com//api/laravelt.json").into(imageView);
    }

    // unutk menghitung jumlah data list yang ada
    @Override
    public int getItemCount() {
        return list.size();
    }

    // class holder item
    class MyViewHolder extends RecyclerView.ViewHolder {

        // variable component
        private MakeupItem item;
        private ImageView imgProduct;
        private TextView nameProduct;
        private CardView cvMakeup;
        private int position;

        // constructor class
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            findView();
        }

        // bind(untuk memasukan data)
        void bind(MakeupItem item, int position) {
            this.item = item;
            this.position = position;
            initView();
        }

        // fungsi untuk memanggil dan set id
        private void findView() {
            imgProduct = itemView.findViewById(R.id.img_product);
            nameProduct = itemView.findViewById(R.id.name_product);
            cvMakeup = itemView.findViewById(R.id.cv_product);
        }

        // untuk set data kedalam komponent item view(list layout)
        private void initView() {
            nameProduct.setText(item.getProduct());

        }

    }
}
