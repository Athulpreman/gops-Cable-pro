package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addnewwokr extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;
    String sname,saddress,sphone,semail,swrkrid,sdesignation;
    AddnewwokrModel addnewwokrModel;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewwokr);
        e1=(EditText)findViewById(R.id.ee1);
        e2=(EditText)findViewById(R.id.ee2);
        e3=(EditText)findViewById(R.id.ee3);
        e4=(EditText)findViewById(R.id.ee4);
        e5=(EditText)findViewById(R.id.ee5);
        e6=(EditText)findViewById(R.id.ee6);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        addnewwokrModel=new AddnewwokrModel();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdesignation=e6.getText().toString();
                sname=e1.getText().toString();
                semail=e4.getText().toString();
                sphone=e3.getText().toString();
                saddress=e2.getText().toString();
                swrkrid=e5.getText().toString();

                if (sname.isEmpty())
                {
                    e1.setError("entr name");
                    e1.requestFocus();
                }
                else if (saddress.isEmpty())
                {
                    e2.setError("entr address");
                    e2.requestFocus();
                }
                else if (sphone.isEmpty())
                {
                    e3.setError("entr phone");
                    e3.requestFocus();
                }
                else if (semail.isEmpty())
                {
                    e4.setError("entr email");
                    e4.requestFocus();
                }
              else   if (swrkrid.isEmpty())
                {
                    e5.setError("entr wrkrid");
                    e5.requestFocus();
                }
            else if (sdesignation.isEmpty())
                {
                    e1.setError("entr desiginatn");
                    e1.requestFocus();
                }
            else{
                sphone="+91"+sphone;

                   addnewwokrModel.setWaddress(saddress);
                   addnewwokrModel.setWdesignation(sdesignation);
                   addnewwokrModel.setWemail(semail);
                   addnewwokrModel.setWphone(sphone);
                   addnewwokrModel.setWwrkrid(swrkrid);
                   addnewwokrModel.setWname(sname);
                    reference= FirebaseDatabase.getInstance().getReference().child("area").child(sdesignation);
                    reference.setValue(addnewwokrModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Addnewwokr.this, "success", Toast.LENGTH_SHORT).show();

                            e1.setText("");
                            e2.setText("");
                            e3.setText("");
                            e4.setText("");
                            e5.setText("");
                            e6.setText("");
                        }
                    });
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(getApplicationContext(),Adminpage.class);
                startActivity(ii);
            }
        });
    }
}
