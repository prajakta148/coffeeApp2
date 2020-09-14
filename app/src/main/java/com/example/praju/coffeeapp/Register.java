package com.example.praju.coffeeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText mail,pass;
    Button btnlogin,btnsignup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mail=(EditText)findViewById(R.id.etmail);
        pass=(EditText)findViewById(R.id.etpass);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnsignup=(Button)findViewById(R.id.btnsignup);

        firebaseAuth=FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass1;
                email=mail.getText().toString();
                pass1=pass.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Register.this,"Successful Login",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,Order.class));
                        }
                        else {
                            Toast.makeText(Register.this,"Unsuccessful Login",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass1;
                email=mail.getText().toString();
                pass1=pass.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(Register.this,"SignUp Successful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Register.this,"SignUp Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
