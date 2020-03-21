package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Usrpage extends AppCompatActivity {
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usrpage);
        b1=(Button)findViewById(R.id.bn1);
        b2=(Button)findViewById(R.id.bn2);
        b3=(Button)findViewById(R.id.bn3);
        b4=(Button)findViewById(R.id.bn4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Uprofile.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Unotifictn.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Ucomplnt.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=getSharedPreferences("ulogin",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();

                Intent i=new Intent(getApplicationContext(),Usrlogin.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}
