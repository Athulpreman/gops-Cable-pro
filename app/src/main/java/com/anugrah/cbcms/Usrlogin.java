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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class  Usrlogin extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    TextView t1,t2;
    String adminid,adminpass;
    DatabaseReference reference,refe;
    AddnewusrModel addnewusrModel;
    ArrayList<String> arr;
    AddnewwokrModel addnewwokrModel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usrlogin);
        e1=(EditText)findViewById(R.id.adid);
        e2=(EditText)findViewById(R.id.adpass);
        t1=(TextView)findViewById((R.id.re));
        t2=(TextView)findViewById((R.id.fo));
        b1=(Button)findViewById(R.id.bt1);
        addnewusrModel=new AddnewusrModel();
        addnewwokrModel1=new AddnewwokrModel();
        arr=new ArrayList<String>();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminid=e1.getText().toString();
                adminpass=e2.getText().toString();
                if (adminpass.equals("0000"))
                {
                    Toast.makeText(Usrlogin.this, "Wrong Password", Toast.LENGTH_SHORT).show();
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

                                        if (adminid.equals(addnewusrModel.Uconsno))
                                        {
                                           if (adminpass.equals(addnewusrModel.Upass))
                                           {
                                               Toast.makeText(Usrlogin.this, "success", Toast.LENGTH_SHORT).show();
                                               SharedPreferences.Editor editor=getSharedPreferences("ulogin",MODE_PRIVATE).edit();
                                               editor.putString("consumerNum",addnewusrModel.Uconsno);
                                               editor.putString("area",addnewusrModel.Uarea);
                                               editor.commit();

                                               Intent intent=new Intent(getApplicationContext(),Usrpage.class);
                                               startActivity(intent);
                                           }
                                        }
                                        else
                                        {

                                        }
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
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re=new Intent(getApplicationContext(),Upasswrd.class);
                startActivity(re);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fo=new Intent(getApplicationContext(),Upasswrd.class);
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
