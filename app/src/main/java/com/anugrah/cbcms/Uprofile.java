package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Uprofile extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    DatabaseReference reference;
    AddnewusrModel addnewusrModel;
    String id,workerarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uprofile);

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        id=sharedPreferences.getString("Ucons",null);
        workerarea=sharedPreferences.getString("areaa",null);

        e1=(EditText)findViewById(R.id.id1);
        e2=(EditText)findViewById(R.id.id2);
        e3=(EditText)findViewById(R.id.id3);
        e4=(EditText)findViewById(R.id.id4);
        e5=(EditText)findViewById(R.id.id5);
        e6=(EditText)findViewById(R.id.id6);

        addnewusrModel=new AddnewusrModel();

        reference= FirebaseDatabase.getInstance().getReference().child("area");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    addnewusrModel=snapshot.getValue(AddnewusrModel.class);

                    if (addnewusrModel.Uarea.equals(workerarea))
                    {
                        e1.setText(addnewusrModel.Uname);
                        e2.setText(addnewusrModel.Uaddress);
                        e3.setText(addnewusrModel.Uphone);
                        e4.setText(addnewusrModel.Uemail);
                        e5.setText(addnewusrModel.Uconsno);
                        e6.setText(addnewusrModel.Usectnboxno);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Uprofile.this, "Database Error...!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}