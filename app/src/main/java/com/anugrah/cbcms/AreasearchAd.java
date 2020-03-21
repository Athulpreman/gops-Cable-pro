package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AreasearchAd extends AppCompatActivity
{
    DatabaseReference refee,refAuto;
    String desination;
    RecyclerView recyclerView;
    AdapterCustomerList adapter;
    ArrayList<AddnewusrModel> list;
    ArrayList<String> listDesi;
    AutoCompleteTextView ACtextview;
    AddnewusrModel addnewusrModel;
    AddnewwokrModel addnewwokrModel;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areasearch_ad);

        ACtextview=(AutoCompleteTextView) findViewById(R.id.actv);
        search=(Button)findViewById(R.id.search);
        addnewwokrModel=new AddnewwokrModel();

        recyclerView=(RecyclerView)findViewById(R.id.rv_Customer_List);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<AddnewusrModel>();
        listDesi=new ArrayList<String>();

        refAuto=FirebaseDatabase.getInstance().getReference().child("area");
        refAuto.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    addnewwokrModel=dataSnapshot1.getValue(AddnewwokrModel.class);
                    String ss;
                    ss=addnewwokrModel.Wdesignation;
                    listDesi.add(ss);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,listDesi);
        ACtextview.setAdapter(adapter1);

       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               desination=ACtextview.getText().toString();
               if (desination.isEmpty())
               {
                   Toast.makeText(AreasearchAd.this, "Type correct area name", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   refee= FirebaseDatabase.getInstance().getReference().child("area").child(desination).child("users");
                   refee.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                       {

                           for (DataSnapshot studentDatasnapshot : dataSnapshot.getChildren())
                           {

                               AddnewusrModel addnewusrModel = studentDatasnapshot.getValue(AddnewusrModel.class);
                               list.add(addnewusrModel);

                           }

                           adapter = new AdapterCustomerList(AreasearchAd.this,list);
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
       });

    }
}
