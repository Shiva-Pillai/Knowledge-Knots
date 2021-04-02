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

public class JoinClubActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText email,user_name,password,confirm_pas;
    Button btn_bec_mem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_club);

        mAuth = FirebaseAuth.getInstance();

        user_name = (EditText) findViewById(R.id.usr_name);
        email = (EditText) findViewById(R.id.email_address);
        password = (EditText) findViewById(R.id.password);
        confirm_pas = (EditText) findViewById(R.id.confirm_pass);

        btn_bec_mem = (Button) findViewById(R.id.btn_Become_Member);

        btn_bec_mem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str_email = email.getText().toString().trim();
                String str_name = user_name.getText().toString().trim();
                String str_pass = password.getText().toString().trim();
                String str_confirm = confirm_pas.getText().toString().trim();

                if(TextUtils.isEmpty(str_name))
                {
                    user_name.setError("Cannot be Empty");
                    Toast.makeText(JoinClubActivity.this,"Please enter a name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(str_email))
                {
                    user_name.setError("Cannot be Empty");
                    Toast.makeText(JoinClubActivity.this,"Please enter email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(str_pass))
                {
                    user_name.setError("Cannot be Empty");
                    Toast.makeText(JoinClubActivity.this,"Please enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(str_confirm))
                {
                    user_name.setError("Cannot be Empty");
                    Toast.makeText(JoinClubActivity.this,"Please enter confirm password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (str_pass.length() < 5)
                {
                    user_name.setError("Length should be more than 5 ");
                    Toast.makeText(JoinClubActivity.this,"Size of Password must be greater than 5 ",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!str_pass.equals(str_confirm))
                {
                    Toast.makeText(JoinClubActivity.this,"Password and Confirm Password Does not Match",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(str_pass.equals(str_confirm))
                {
                    mAuth.createUserWithEmailAndPassword(str_email, str_pass)
                            .addOnCompleteListener(JoinClubActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Intent intent = new Intent(JoinClubActivity.this,SignInActivity.class);
                                        startActivity(intent);
                                        Toast.makeText(JoinClubActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                                    } else {

                                        Toast.makeText(JoinClubActivity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

    }
}
