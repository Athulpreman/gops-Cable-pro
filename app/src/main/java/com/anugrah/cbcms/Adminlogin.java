package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String adminid,adminpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        e1=(EditText)findViewById(R.id.adid);
        e2=(EditText)findViewById(R.id.adpass);
        b1=(Button)findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminid=e1.getText().toString();
                adminpass=e2.getText().toString();
                if(adminid.equals("1234")&&adminpass.equals("1234"))
                {
                    Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),Adminpage.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login fail",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent pp=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(pp);
    }
}
