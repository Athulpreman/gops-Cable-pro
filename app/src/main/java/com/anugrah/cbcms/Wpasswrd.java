package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Wpasswrd extends  AppCompatActivity {
    EditText e1;
    Button b1;
    String phoneno,mobno,wid,area;
    DatabaseReference reference;
    AddnewwokrModel addnewwokrModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wpasswrd);

        addnewwokrModel=new AddnewwokrModel();
        e1=(EditText)findViewById(R.id.adid);
        b1=(Button) findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wid = e1.getText().toString();
                if (wid.isEmpty())
                {
                    e1.setError("Enter id");
                }

                reference= FirebaseDatabase.getInstance().getReference().child("area");

                reference.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                       for (DataSnapshot snapshot:dataSnapshot.getChildren())
                       {
                           if (dataSnapshot.exists())
                           {
                               addnewwokrModel=snapshot.getValue(AddnewwokrModel.class);

                               if (wid.equals(addnewwokrModel.Wwrkrid))
                               {
                                   phoneno=addnewwokrModel.Wphone;
                                   area=addnewwokrModel.Wdesignation;
                                   Intent intent=new Intent(getApplicationContext(),Otp.class);
                                   intent.putExtra("signMobile",phoneno);
                                   intent.putExtra("area",area);
                                   startActivity(intent);
                               }
                           }
                           else
                           {
                               Toast.makeText(Wpasswrd.this, "else", Toast.LENGTH_SHORT).show();
                           }
                       }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError)
                    {

                    }
                });
            }
        });
    }
}
