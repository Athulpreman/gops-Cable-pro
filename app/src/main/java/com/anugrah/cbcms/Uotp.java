package com.anugrah.cbcms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class Uotp extends AppCompatActivity
{
    String verificationcode,mobno,password,name,area,uid;
    ProgressBar progressBar;
    EditText editText;
    Button button;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    AddnewusrModel addnewusrModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uotp);



        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        editText=(EditText)findViewById(R.id.adid);
        button=(Button)findViewById(R.id.bt1);

        mAuth=FirebaseAuth.getInstance();
        addnewusrModel=new AddnewusrModel();

        reference= FirebaseDatabase.getInstance().getReference().child("area");

        Intent intent=getIntent();
        mobno=intent.getStringExtra("signMobile");
        area=intent.getStringExtra("area");
        uid=intent.getStringExtra("uid");
        mobno="+91"+mobno;

        sendVerificationCode(mobno);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String code=editText.getText().toString().trim();
                if (code.isEmpty()||code.length()<6)
                {
                    editText.setError("Enter code...!");
                    editText.requestFocus();
                    return;
                }
                verfyCode(code);

            }
        });

    }
    public void verfyCode(String code)
    {
        editText.setText(code);
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationcode, code);
        signInWithCredential(credential);
    }
    void signInWithCredential(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {

                    Toast.makeText(getApplicationContext(), "Sucessfull", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Unewpasswrd.class);
                    intent.putExtra("mob1",mobno);
                    intent.putExtra("area",area);
                    intent.putExtra("uid",uid);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });
    }

    public void sendVerificationCode(String num)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(num,60, TimeUnit.SECONDS,this,mCallBack);

    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
        {
            String code=phoneAuthCredential.getSmsCode();
            if (code!=null)
            {
                progressBar.setVisibility(View.VISIBLE);
                verfyCode(code);
            }

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationcode=s;
        }

        @Override
        public void onVerificationFailed(FirebaseException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    };


}
