package com.dekvii.LARAVELT.Adapter.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dekvii.LARAVELT.Model.product.SkincareItem;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

public class SkincareAdapter extends RecyclerView.Adapter<SkincareAdapter.MyViewHolder> {

    private Context context;
    private List<SkincareItem> list = new ArrayList<>();
    private OnItemClickListener listener;

    // method constructor
    public SkincareAdapter(Context context) {
        this.context = context;
    }

    // method untuk menset data berupa list
    public void setData(List<SkincareItem> list) {
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
        SkincareItem item = list.get(position);
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
        private SkincareItem item;
        private ImageView imgProduct;
        private TextView nameProduct;
        private int position;

        // constructor class
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            findView();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        // bind(untuk memasukan data)
        void bind(SkincareItem item) {
            this.item = item;
            initView();
        }

        // fungsi untuk memanggil dan set id
        private void findView() {
            imgProduct = itemView.findViewById(R.id.img_product);
            nameProduct = itemView.findViewById(R.id.name_product);

        }

        // untuk set data kedalam komponent item view(list layout)
        private void initView() {
            Glide.with(context).load(item.getPicture() ).into(imgProduct);
            nameProduct.setText(item.getProduct());

        }

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


}
