package com.dekvii.LARAVELT.Adapter.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dekvii.LARAVELT.Model.product.BodycareItem;
import com.dekvii.LARAVELT.R;

import java.util.ArrayList;
import java.util.List;

public class BodycareAdapter extends RecyclerView.Adapter<BodycareAdapter.MyViewHolder> {

    private Context context;
    private List<BodycareItem> list = new ArrayList<>();
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = mListener;
    }

    // method constructor
    public BodycareAdapter(Context context) {
        this.context = context;
    }

    // method untuk menset data berupa list
    public void setData(List<BodycareItem> list) {
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
        BodycareItem item = list.get(position);
        // lalu di masukan ke dalam class holder melalui method bind
        holder.bind(item);
    }


    // untuk menghitung jumlah data list yang ada
    @Override
    public int getItemCount() {
        return list.size();
    }

    // class holder item
    class MyViewHolder extends RecyclerView.ViewHolder {

        // variable component
        private BodycareItem item;
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
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        // bind(untuk memasukan data)
        void bind(BodycareItem item) {
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
            Glide.with(context).load(item.getPicture()).into(imgProduct);

            nameProduct.setText(item.getProduct());
        }

    }
}
