package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Wprofile extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    DatabaseReference reference;
    AddnewwokrModel addnewwokrModel;
    String id,workerarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprofile);
        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        id=sharedPreferences.getString("workerid",null);
        workerarea=sharedPreferences.getString("desi",null);
        e1=(EditText)findViewById(R.id.id1);
        e2=(EditText)findViewById(R.id.id2);
        e3=(EditText)findViewById(R.id.id3);
        e4=(EditText)findViewById(R.id.id4);
        e5=(EditText)findViewById(R.id.id5);
        e6=(EditText)findViewById(R.id.id6);

        addnewwokrModel=new AddnewwokrModel();
          Log.d("aaaa","pp");
        reference= FirebaseDatabase.getInstance().getReference().child("area");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Log.d("aaaa","im");
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    addnewwokrModel=snapshot.getValue(AddnewwokrModel.class);
                 Log.d("aaaa","yy");
                 if (workerarea.equals(addnewwokrModel.Wdesignation))
                    {
                        Log.d("aaaa","rr");
                        e1.setText(addnewwokrModel.Wwrkrid);
                        e2.setText(addnewwokrModel.Wname);
                        e3.setText(addnewwokrModel.Waddress);
                        e4.setText(addnewwokrModel.Wphone);
                        e5.setText(addnewwokrModel.Wemail);
                        e6.setText(addnewwokrModel.Wdesignation);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Wprofile.this, "Database Error...!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}