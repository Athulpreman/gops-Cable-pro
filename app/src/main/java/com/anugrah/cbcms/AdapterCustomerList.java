package com.anugrah.cbcms;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class AdapterCustomerList extends RecyclerView.Adapter<AdapterCustomerList.OwnerViewHolder>
{

    private ArrayList<AddnewusrModel> customerList;
    Context context;

    AdapterCustomerList(Context context, ArrayList<AddnewusrModel> itemList)
    {
        this.context = context;
        customerList = itemList;
    }

    @NonNull
    @Override
    public OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater=LayoutInflater.from((Context) context);
        View view=layoutInflater.inflate(R.layout.cardview_customer_list,null);
        return new OwnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OwnerViewHolder holder, final int position)
    {

        holder.t1.setText(customerList.get(position).getUconsno());
        holder.t2.setText(customerList.get(position).getUname());

    }

    @Override
    public int getItemCount()

    {
        return customerList.size();
    }

    class OwnerViewHolder extends RecyclerView.ViewHolder
    {
        EditText t1,t2;

        public OwnerViewHolder(@NonNull View ownerView) {
            super(ownerView);
            t1=(EditText) ownerView.findViewById(R.id.id6);
            t2=(EditText) ownerView.findViewById(R.id.id7);


        }
    }
}






