package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.Owner;
import java.util.ArrayList;

public class AWorkrlist extends AppCompatActivity
{
    DatabaseReference refee;
    RecyclerView recyclerView;
    AdapterWorkerList adapter;
    ArrayList<AddnewwokrModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aworkrlist);


        recyclerView=(RecyclerView)findViewById(R.id.rv_Worker_List);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<AddnewwokrModel>();

        refee= FirebaseDatabase.getInstance().getReference().child("area");
        refee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot studentDatasnapshot : dataSnapshot.getChildren())
                {
                    AddnewwokrModel addnewwokrModel = studentDatasnapshot.getValue(AddnewwokrModel.class);
                    list.add(addnewwokrModel);

                }
                adapter = new AdapterWorkerList(AWorkrlist.this,list);
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
