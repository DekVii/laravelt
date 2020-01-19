package com.dekvii.LARAVELT.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;


// class adapter recyeclerview
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

        private Context context;
        private List<Integer> list = new ArrayList<>();

        // method constructor
        public MenuAdapter(Context context) {
                this.context = context;
        }

        // method untuk menset data berupa list
        public void setData(List<Integer>  list) {
                this.list = list;
                notifyDataSetChanged();
        }

        // berfungsi untuk menentukan layout dari list item
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_menu, parent, false));
        }

        // funsi untuk memasukan data ke dalam list item(class holder)
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                // data list di ambil berdasarkan posisinya
                Integer image = list.get(position);
                // lalu di masukan ke dalam class holder melalui method bind
                holder.bind(image);
        }

        // unutk menghitung jumlah data list yang ada
        @Override
        public int getItemCount() {
                return list.size();
        }

        // class holder item
        class MyViewHolder extends RecyclerView.ViewHolder {

                // variable component
                private Integer image;
                private ImageView ivMenu;

                // constructor class
                MyViewHolder(@NonNull View itemView) {
                        super(itemView);
                        findView();
                }

                // bind(untuk memasukan data)
                void bind(Integer image) {
                        this.image = image;
                        initView();
                }

                // fungsi untuk memanggil dan set id
                private void findView() {
                        ivMenu = itemView.findViewById(R.id.img_item);
                // tvCat = itemView.findViewById(R.id.tv_makul_item_presnce);
                }

                // untuk set data kedalam komponent item view(list layout)
                private void initView() {
                        ivMenu.setImageResource(image);
                }

        }

}

