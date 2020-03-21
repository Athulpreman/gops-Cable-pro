package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Viewcomplts extends AppCompatActivity {

    Button B1,B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcomplts);
        B1 = (Button) findViewById(R.id.bt2);
        B2 = (Button) findViewById(R.id.bt3);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie = new Intent(getApplicationContext(), Movetofix.class);
                startActivity(ie);
            }
        });
      B2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),Movetounsolved.class);
              startActivity(i);
          }
      });
    }
}