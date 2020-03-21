package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Unewpasswrd extends AppCompatActivity
{
    EditText e1,e2;
    Button b1;
    String s1,s2,mob,area,uid;
    DatabaseReference reference;
    AddnewusrModel addnewusrModel;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unewpasswrd);

        e1=(EditText)findViewById(R.id.adid);
        e2=(EditText)findViewById(R.id.adid1);
        b1=(Button)findViewById(R.id.bt1);

        Intent intent=getIntent();
        mob=intent.getStringExtra("mob1");
        area=intent.getStringExtra("area");
        uid=intent.getStringExtra("uid");
        Toast.makeText(this, area, Toast.LENGTH_SHORT).show();

        reference= FirebaseDatabase.getInstance().getReference().child("area").child(area).child("users").child(uid);

        addnewusrModel=new AddnewusrModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                s1=e1.getText().toString();
                s2=e2.getText().toString();


                if (s1.equals(s2))
                {
                    if (s1.equals("0000"))
                    {
                        Toast.makeText(Unewpasswrd.this, "chose a diffrent password", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Query query=reference.orderByChild("uphone").equalTo(mob);
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                            {
                                addnewusrModel=dataSnapshot.getValue(AddnewusrModel.class);
                                dataSnapshot.getRef().child("upass").setValue(s1);
                                Toast.makeText(Unewpasswrd.this, "Password set", Toast.LENGTH_SHORT).show();
                                e1.setText("");
                                e2.setText("");



                                Intent i=new Intent(getApplicationContext(),Usrpage.class);
                                startActivity(i);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError)
                            {
                                Toast.makeText(Unewpasswrd.this, "Database Error...!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
                else
                {
                    Toast.makeText(Unewpasswrd.this, "Password doesnt match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
