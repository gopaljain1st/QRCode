package com.example.cangoproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etName,etPassword;
    SharedPreferences sp=null;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.login);
        etName=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPassword);
       sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().equals("vendor") && etPassword.getText().toString().equals("vendor123")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", "vendor");
                    editor.putString("password", "vendor123");
                    editor.commit();
                    Intent intent=new Intent(LoginActivity.this,SiteActivity.class);
                    intent.putExtra("id",1);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "User name & Password Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sharedPreferences.getString("name","").equals("vendor") && sharedPreferences.getString("password","").equals("vendor123")){
            Intent intent=new Intent(LoginActivity.this,SiteActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
