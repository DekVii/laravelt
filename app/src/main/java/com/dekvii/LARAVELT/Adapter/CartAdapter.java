package com.dekvii.LARAVELT.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.R;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private static final String TAG = "CartAdapter";

    private String[] mDataSet;
    private String[] mDataSet2;
    private String[] mDataSet3;
    private int[] mDataSet4;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView product_cart,price_cart,amount_cart;
        private final ImageView img_cart;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            product_cart = (TextView) v.findViewById(R.id.product_cart);
            price_cart = (TextView) v.findViewById(R.id.price_cart);
            amount_cart = (TextView) v.findViewById(R.id.amount_cart);
            img_cart = (ImageView) v.findViewById(R.id.img_cart);
        }

        public TextView getProduct_cart() {
            return product_cart;
        }
        public TextView getPrice_cart() {
            return price_cart;
        }
        public TextView getamount_cart() { return amount_cart; }
        public ImageView getImg_cart() { return img_cart;
        }
    }

    public CartAdapter(String[] dataSet,String[] dataSet2,String[] dataSet3, int[] dataSet4) {
        this.mDataSet = dataSet;
        this.mDataSet2 = dataSet2;
        this.mDataSet3 = dataSet3;
        this.mDataSet4 = dataSet4;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ui_cart, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");


        viewHolder.getProduct_cart().setText(mDataSet[position]);
        viewHolder.getPrice_cart().setText(mDataSet2[position]);
        viewHolder.getamount_cart().setText(mDataSet3[position]);
        viewHolder.getImg_cart().setImageResource(mDataSet4[position]);
    }
    public int getItemCount() {
        return mDataSet.length;
    }
}