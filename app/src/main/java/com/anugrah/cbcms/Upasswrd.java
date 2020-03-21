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

import java.util.ArrayList;

public class Upasswrd extends  AppCompatActivity {
    EditText e1;
    Button b1;
    String phoneno,mobno,cons,area,uid;
    DatabaseReference reference,refe;
    AddnewusrModel addnewusrModel;
    AddnewwokrModel addnewwokrModel1;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upasswrd);

        addnewusrModel=new AddnewusrModel();
        e1=(EditText)findViewById(R.id.adid1);
        b1=(Button) findViewById(R.id.bt3);
        arr=new ArrayList<String>();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cons = e1.getText().toString();
                if (cons.isEmpty())
                {
                    e1.setError("Enter id");
                }
                else
                {
                    refe=FirebaseDatabase.getInstance().getReference().child("area");
                    refe.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot snapshot:dataSnapshot.getChildren() )
                            {
                                addnewwokrModel1=new AddnewwokrModel();
                                addnewwokrModel1=snapshot.getValue(AddnewwokrModel.class);
                                String sdesi=addnewwokrModel1.Wdesignation;
                                arr.add(sdesi);

                                Log.d("aaaaa","a");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {


                        }
                    });

                    for (String s:arr)
                    {
                        reference= FirebaseDatabase.getInstance().getReference().child("area").child(s).child("users");

                        reference.addValueEventListener(new ValueEventListener()
                        {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                            {
                                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                                {
                                    if (dataSnapshot.exists())
                                    {
                                        addnewusrModel=snapshot.getValue(AddnewusrModel.class);

                                        if (cons.equals(addnewusrModel.Uconsno))
                                        {
                                            phoneno=addnewusrModel.Uphone;
                                            area=addnewusrModel.Uarea;
                                            uid=addnewusrModel.Uconsno;

                                            Intent intent=new Intent(getApplicationContext(),Uotp.class);
                                            intent.putExtra("signMobile",phoneno);
                                            intent.putExtra("uid",uid);
                                            intent.putExtra("area",area);
                                            startActivity(intent);
                                        }
                                    }
                                    else
                                    {
                                        Toast.makeText(Upasswrd.this, "else", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError)
                            {

                            }
                        });
                    }
                }
            }
        });
    }
}
