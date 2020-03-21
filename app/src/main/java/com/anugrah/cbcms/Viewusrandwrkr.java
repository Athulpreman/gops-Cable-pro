package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Viewusrandwrkr extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewusrandwrkr);
        b1=(Button)findViewById(R.id.bu2);
        b2=(Button)findViewById(R.id.bu1);
           b1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i=new Intent(getApplicationContext(),AreasearchAd.class);
                   startActivity(i);
               }
           });
           b2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent i=new Intent(getApplicationContext(),AWorkrlist.class);
                   startActivity(i);
               }
           });
    }
}
