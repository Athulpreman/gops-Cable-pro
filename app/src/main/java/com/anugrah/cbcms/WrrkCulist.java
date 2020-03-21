package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WrrkCulist extends AppCompatActivity
{

    String desi;
    DatabaseReference reference;
    AddnewusrModel addnewusrModel;
    ArrayList<AddnewusrModel>list;
    DatabaseReference refee;
    RecyclerView recyclerView;
    AdapterWC adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrrk_culist);

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        desi=sharedPreferences.getString("desi",null);

        recyclerView=(RecyclerView)findViewById(R.id.rvCustomer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addnewusrModel=new AddnewusrModel();
        list=new ArrayList<AddnewusrModel>();

        
        reference= FirebaseDatabase.getInstance().getReference().child("area").child(desi).child("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    addnewusrModel=snapshot.getValue(AddnewusrModel.class);
                    list.add(addnewusrModel);
                }
                adapter = new AdapterWC(WrrkCulist.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(getApplicationContext(),"something wnt wrong",Toast.LENGTH_LONG).show();
            }
        });

    }
}
