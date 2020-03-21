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

public class Addnewusr extends AppCompatActivity {
    String Uname, Uaddress, Uphon, Uemail, Uconsumerno, Usectionboxno,Uarea;
    EditText e1, e2, e3, e4, e5, e6,e7;
    Button b1, b2;
    AddnewusrModel AddnewusrModel;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewusr);
        e1 = (EditText) findViewById(R.id.id1);
        e2 = (EditText) findViewById(R.id.id2);
        e3 = (EditText) findViewById(R.id.id3);
        e4 = (EditText) findViewById(R.id.id4);
        e5 = (EditText) findViewById(R.id.id5);
        e6 = (EditText) findViewById(R.id.id6);
        e7 = (EditText) findViewById(R.id.id7);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        AddnewusrModel = new AddnewusrModel();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uname = e1.getText().toString();
                Uaddress = e2.getText().toString();
                Uphon = e3.getText().toString();
                Uemail = e4.getText().toString();
                Uconsumerno = e5.getText().toString();
                Usectionboxno = e6.getText().toString();
                Uarea = e7.getText().toString();

                if (Uname.isEmpty()) {
                    e1.setError("usr name required");
                    e1.requestFocus();
                } else if (Uaddress.isEmpty()) {
                    e2.setError("usr address required");
                    e2.requestFocus();
                } else if (Uphon.isEmpty()) {
                    e3.setError("usr phon required");
                    e3.requestFocus();
                } else if (Uemail.isEmpty()) {
                    e4.setError("usr email required");
                    e4.requestFocus();
                } else if (Uconsumerno.isEmpty()) {
                    e5.setError("usr consumno required");
                    e5.requestFocus();
                } else if (Uname.isEmpty()) {
                    e6.setError("usr sectonboxno required");
                    e6.requestFocus();
                }
                else if (Uarea.isEmpty()) {
                    e7.setError("usr sectonboxno required");
                    e7.requestFocus();
                }
                    else {
                    AddnewusrModel.setUaddress(Uaddress);
                    AddnewusrModel.setUsectnboxno(Usectionboxno);
                    AddnewusrModel.setUemail(Uemail);
                    AddnewusrModel.setUphone(Uphon);
                    AddnewusrModel.setUconsno(Uconsumerno);
                    AddnewusrModel.setUname(Uname);
                    AddnewusrModel.setUarea(Uarea);
                    reference= FirebaseDatabase.getInstance().getReference().child("area").child(Uarea).child("users").child(Uconsumerno);
                    reference.setValue(AddnewusrModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Addnewusr.this, "success", Toast.LENGTH_SHORT).show();
                            e1.setText("");
                            e2.setText("");
                            e3.setText("");
                            e4.setText("");
                            e5.setText("");
                            e6.setText("");
                            e7.setText("");
                        }
                    });

                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(), Adminpage.class);
                startActivity(ii);
            }
        });
    }
}





