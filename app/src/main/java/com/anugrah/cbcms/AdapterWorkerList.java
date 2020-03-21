package com.anugrah.cbcms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterWorkerList extends RecyclerView.Adapter<AdapterWorkerList.OwnerViewHolder>
{
    private ArrayList<AddnewwokrModel> workerList;
    Context context;

    AdapterWorkerList(Context context, ArrayList<AddnewwokrModel> itemList)
    {
        this.context = context;
        workerList = itemList;
    }

    @NonNull
    @Override
    public OwnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater=LayoutInflater.from((Context) context);
        View view=layoutInflater.inflate(R.layout.carview_worker_list,null);
        return new OwnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OwnerViewHolder holder, final int position)
    {
        holder.t1.setText(workerList.get(position).getWwrkrid());
        holder.t2.setText(workerList.get(position).getWname());

    }

    @Override
    public int getItemCount()

    {
        return workerList.size();
    }

    class OwnerViewHolder extends RecyclerView.ViewHolder
    {
        EditText t1,t2;

        public OwnerViewHolder(@NonNull View ownerView) {
            super(ownerView);
            t1=(EditText) ownerView.findViewById(R.id.id8);
            t2=(EditText) ownerView.findViewById(R.id.id4);


        }
    }
}
