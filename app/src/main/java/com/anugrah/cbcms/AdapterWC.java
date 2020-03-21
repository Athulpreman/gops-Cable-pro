package com.anugrah.cbcms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterWC extends RecyclerView.Adapter<AdapterWC.OwnerViewHolder>
{
    private ArrayList<AddnewusrModel> customerList;
    Context context;

    AdapterWC(Context context, ArrayList<AddnewusrModel> itemList)
    {
        this.context = context;
        customerList = itemList;
    }

    @NonNull
    @Override
    public AdapterWC.OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater=LayoutInflater.from((Context) context);
        View view=layoutInflater.inflate(R.layout.cardview_wc,null);
        return new AdapterWC.OwnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterWC.OwnerViewHolder holder, final int position)
    {

        holder.t1.setText(customerList.get(position).getUsectnboxno());
        holder.t2.setText(customerList.get(position).getUname());
        holder.t3.setText(customerList.get(position).getUphone());

    }

    @Override
    public int getItemCount()

    {
        return customerList.size();
    }

    class OwnerViewHolder extends RecyclerView.ViewHolder
    {
        EditText t1,t2,t3;

        public OwnerViewHolder(@NonNull View ownerView) {
            super(ownerView);
            t1=(EditText) ownerView.findViewById(R.id.id6);
            t2=(EditText) ownerView.findViewById(R.id.id7);
            t3=(EditText) ownerView.findViewById(R.id.id8);


        }
    }
}
