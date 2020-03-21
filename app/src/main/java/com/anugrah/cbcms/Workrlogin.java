package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class  Workrlogin extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    TextView t1,t2;
    String adminid,adminpass;
    DatabaseReference reference;
    AddnewwokrModel addnewwokrModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workrlogin);
        e1=(EditText)findViewById(R.id.adid);
        e2=(EditText)findViewById(R.id.adpass);
        t1=(TextView)findViewById((R.id.re));
        t2=(TextView)findViewById((R.id.fo));
        b1=(Button)findViewById(R.id.bt1);
        addnewwokrModel=new AddnewwokrModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminid=e1.getText().toString();
                adminpass=e2.getText().toString();
                if (adminpass.equals("0000"))
                {
                    Toast.makeText(Workrlogin.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    reference= FirebaseDatabase.getInstance().getReference().child("area");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                        {
                            for (DataSnapshot snapshot:dataSnapshot.getChildren())
                            {
                                addnewwokrModel=snapshot.getValue(AddnewwokrModel.class);
                                if (adminid.equals(addnewwokrModel.Wwrkrid))
                                {
                                    if (adminpass.equals(addnewwokrModel.Wpass))
                                    {
                                        Toast.makeText(Workrlogin.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();

                                        SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
                                        editor.putString("workerid",addnewwokrModel.Wwrkrid);
                                        editor.putString("desi",addnewwokrModel.Wdesignation);
                                        editor.commit();

                                        Intent intent=new Intent(getApplicationContext(),Workrpage.class);
                                        startActivity(intent);

                                    }
                                    else
                                    {
                                        Toast.makeText(Workrlogin.this,"wrong passwrd",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError)
                        {
                            Toast.makeText(Workrlogin.this, "Database Error...!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re=new Intent(getApplicationContext(),Wpasswrd.class);
                startActivity(re);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fo=new Intent(getApplicationContext(),Wpasswrd.class);
                startActivity(fo);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
