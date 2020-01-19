package com.dekvii.LARAVELT.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dekvii.LARAVELT.Model.Account;
import com.dekvii.LARAVELT.R;

import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    private Context context;
    private List<Account> account;
    private AdapterView.OnItemClickListener listener;

    public AccountAdapter(Context context){
        this.context = context;
        this.account = account;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_account, viewGroup, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Account account = this.account.get(i);
        viewHolder.tvName.setText(account.getName());
        viewHolder.tvContact.setText(account.getName());
        viewHolder.tvAddress.setText(account.getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, viewHolder.itemView, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return account.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvContact;
        public TextView tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name_user);
            tvContact = itemView.findViewById(R.id.contact_user);
            tvAddress = itemView.findViewById(R.id.address_user);
        }
    }
}
