package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ucomplnt extends AppCompatActivity {

    Button B1,B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucomplnt);
        B1 = (Button) findViewById(R.id.bt2);
        B2 = (Button) findViewById(R.id.bt3);
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie = new Intent(getApplicationContext(), Usrpage.class);
                startActivity(ie);
            }
        });
    }
}