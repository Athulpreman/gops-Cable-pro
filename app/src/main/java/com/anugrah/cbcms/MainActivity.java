package com.anugrah.cbcms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    Toast backToast;
    long backPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Athul");

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        String value=sharedPreferences.getString("workerid",null);
        if (value!=null)
        {
            Intent intent=new Intent(getApplicationContext(),Workrpage.class);
            startActivity(intent);
        }
        SharedPreferences sharedPreferences1=getSharedPreferences("ulogin",MODE_PRIVATE);
        String value1=sharedPreferences1.getString("consumerNum",null);
        if (value1!=null)
        {
            Intent inten=new Intent(getApplicationContext(),Usrpage.class);
            startActivity(inten);
        }

        b1=(Button)findViewById(R.id.adminb);
        b2=(Button)findViewById(R.id.usrb);
        b3=(Button)findViewById(R.id.wrkrb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Adminlogin.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip=new Intent(getApplicationContext(),Usrlogin.class);
                startActivity(ip);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iz=new Intent(getApplicationContext(),Workrlogin.class);
                startActivity(iz);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (backPress +2000>System.currentTimeMillis())
        {
            backToast.cancel();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        else
        {
            backToast=Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPress =System.currentTimeMillis();
    }


}
