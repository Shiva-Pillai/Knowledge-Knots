package com.shivapillai.knowledgeknots;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText et_signin_email , et_signin_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user  = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null)
        {
            Intent intent = new Intent(SignInActivity.this,MainActivity.class);
            Toast.makeText(SignInActivity.this,"Already Logged In",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

        et_signin_email = (EditText) findViewById(R.id.sign_email);
        et_signin_password = (EditText) findViewById(R.id.sign_password);

        Button joinclub_b = findViewById(R.id.joinclub_b);
        btn_login = (Button) findViewById(R.id.btn_login);

        joinclub_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,JoinClubActivity.class);
                Toast.makeText(getApplicationContext(),"Join CLUB",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_email = et_signin_email.getText().toString().trim();
                String str_pass = et_signin_password.getText().toString().trim();

                if(TextUtils.isEmpty(str_email))
                {
                    Toast.makeText(SignInActivity.this,"Cannot be Empty",Toast.LENGTH_SHORT).show();
                    et_signin_email.setError("Email cannot be empty");
                    return;
                }

                if(TextUtils.isEmpty(str_pass))
                {
                    Toast.makeText(SignInActivity.this,"Cannot be Empty",Toast.LENGTH_SHORT).show();
                    et_signin_email.setError("Password cannot be empty");
                    return;
                }

                if(str_pass.length()<5)
                {
                    Toast.makeText(SignInActivity.this,"Length Greater than 5",Toast.LENGTH_SHORT).show();
                    et_signin_email.setError("Length should be greater than 5");
                    return;
                }

                mAuth.signInWithEmailAndPassword(str_email,str_pass).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                            Toast.makeText(SignInActivity.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }

                        else
                        {
                            Toast.makeText(SignInActivity.this,"Invalid Credentials!! \n Please try Again",Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        });

    }
}
