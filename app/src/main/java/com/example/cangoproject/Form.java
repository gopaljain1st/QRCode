package com.example.cangoproject;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Form extends AppCompatActivity
{
    EditText id,name,type,price,description;
    Button submit;
    String date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        initComponent();
        Intent in=getIntent();
        String result=in.getStringExtra("result");
        id.setText(result);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().trim().equals("")||name.getText().toString().trim().equals("")||type.getText().toString().trim().equals("")||price.getText().toString().trim().equals("")
                        || description.getText().toString().trim().equals(""))
                    Toast.makeText(Form.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                 else saveToLocalStorage();
            }
        });
    }
    private void saveToLocalStorage()
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        date=df.format(dateobj);
        DatabaseHelper helper=new DatabaseHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name.getText().toString());
        values.put("item_id",id.getText().toString());
        values.put("type",type.getText().toString());
        values.put("price",price.getText().toString());
        values.put("description",description.getText().toString());
        values.put("date",date);
        db.insert("item",null,values);
        db.close();
        helper.close();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Form.this,HomePageActivity.class));
        finish();
    }
    private void initComponent()
    {
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        type=findViewById(R.id.type);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);
        submit=findViewById(R.id.submit);
    }
}
