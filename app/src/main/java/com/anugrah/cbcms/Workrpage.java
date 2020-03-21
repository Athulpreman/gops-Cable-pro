package com.anugrah.cbcms;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Workrpage extends AppCompatActivity {
    Button b1,b2,b3,b4,B5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workrpage);
        b1=(Button)findViewById(R.id.bn1);
        b2=(Button)findViewById(R.id.bn2);
        b3=(Button)findViewById(R.id.bn3);
        b4=(Button)findViewById(R.id.bn4);
        B5=(Button)findViewById(R.id.bn8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Wprofile.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),wrkrstatus.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Worknotification.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();


                Intent i=new Intent(getApplicationContext(),Workrlogin.class);
                startActivity(i);
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jj=new Intent(getApplicationContext(),WrrkCulist.class);
                startActivity(jj);
            }
        });


    }
    @Override
    public void onBackPressed() {

    }
}
