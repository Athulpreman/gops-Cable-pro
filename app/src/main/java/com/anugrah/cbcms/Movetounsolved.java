package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Movetounsolved extends AppCompatActivity {

    Button B1,B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movetounsolved);
        B1 = (Button) findViewById(R.id.bn3);
        B2 = (Button) findViewById(R.id.bn4);

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie = new Intent(getApplicationContext(), Workrpage.class);
                startActivity(ie);
            }
        });
    }
}