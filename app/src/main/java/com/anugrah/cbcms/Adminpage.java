package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adminpage extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);
        bt1=(Button)findViewById(R.id.b1);
        bt2=(Button)findViewById(R.id.b2);
        bt3=(Button)findViewById(R.id.b8);
        bt4=(Button)findViewById(R.id.b7);
        bt5=(Button)findViewById(R.id.b6);
        bt6=(Button)findViewById(R.id.b9);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Addnewusr.class);
                startActivity(i);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Addnewwokr.class);
                startActivity(i);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Aviewcomplaints.class);
                startActivity(i);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Viewusrandwrkr.class);
                startActivity(i);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Notification.class);
                startActivity(i);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Adminlogin.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
