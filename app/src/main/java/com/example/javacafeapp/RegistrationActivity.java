package com.example.javacafeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.javacafeapp.Database.DBHelper;

public class RegistrationActivity extends AppCompatActivity {

    EditText username,password,repassword;
    Button btnSignUp, btnSignIn;
    DBHelper sqLiteDatabase;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.repassword);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        sqLiteDatabase = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(RegistrationActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else {
                    if (pass.equals(repass)) {
                        Boolean userCheck = sqLiteDatabase.checkUsername(user);
                        if(userCheck == false) {
                            Boolean regResult = sqLiteDatabase.insertData(user, pass);
                            if (regResult == true) {
                                Toast.makeText(RegistrationActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this, "User already exists. Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegistrationActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}