package com.dekvii.LARAVELT.Adapter;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dekvii.LARAVELT.Model.Category;
import com.dekvii.LARAVELT.Model.product.CategoryItem;
import com.dekvii.LARAVELT.Model.product.Product;
import com.dekvii.LARAVELT.Model.product.SkincareItem;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    private List<Category> list = new ArrayList<>();

    // method constructor
    public CategoryAdapter(Context context) {
        this.context = context;
    }

    // method untuk menset data berupa list
    public void setData(List<Category> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    // berfungsi untuk menentukan layout dari list item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false));
    }

    // funsi untuk memasukan data ke dalam list item(class holder)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // data list di ambil berdasarkan posisinya
        Category item = list.get(position);
        // lalu di masukan ke dalam class holder melalui method bind
        holder.bind(item);

    }

    // unutk menghitung jumlah data list yang ada
    @Override
    public int getItemCount() {
        return list.size();
    }

    // class holder item
    class MyViewHolder extends RecyclerView.ViewHolder {

        // variable component
        private Category item;
        private ImageView imgCategory;
        private TextView productCategory;
        private CardView cvCategory;

        // constructor class
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            findView();
        }

        // bind(untuk memasukan data)
        void bind(Category item) {
            this.item = item;
            initView();
        }

        // fungsi untuk memanggil dan set id
        private void findView() {
            imgCategory = itemView.findViewById(R.id.img_category);
            productCategory = itemView.findViewById(R.id.product_category);
            cvCategory = itemView.findViewById(R.id.cv_category);
        }

        // untuk set data kedalam komponent item view(list layout)
        private void initView() {
            Glide.with(context).load(item.getImage()).into(imgCategory);
            productCategory.setText(item.getCategoryTittle());
        }

    }
}
