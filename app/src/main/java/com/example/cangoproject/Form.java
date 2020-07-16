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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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
    EditText id,name,type,price,assetCategory,assocutationGate,expiryDate,seriorNo,region,site,location,deparment,managedBy;
    Button submit;
    Spinner productType,assetState,vendor,assetType;
    String date;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        initComponent();
        Intent in=getIntent();
        String result=in.getStringExtra("result");
        String arr[]=result.split(":|\\\n");
        try
        {
              id.setText(arr[1].trim());
              name.setText(arr[3].trim());
              type.setText(arr[5].trim());
              price.setText(arr[7].trim());
        }
        catch (Exception e)
        {
            id.setText(result);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().trim().equals("")||name.getText().toString().trim().equals("")||type.getText().toString().trim().equals("")||price.getText().toString().trim().equals("")
                        || assetCategory.getText().toString().trim().equals("") || assocutationGate.getText().toString().trim().equals("")
            || expiryDate.getText().toString().trim().equals("") || seriorNo.getText().toString().trim().equals("") ||  region.getText().toString().trim().equals("") || site.getText().toString().trim().equals("") || location.getText().toString().trim().equals("") ||
                deparment.getText().toString().trim().equals("") || managedBy.getText().toString().trim().equals(""))
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
        values.put("item_id",id.getText().toString());
        values.put("n_name",name.getText().toString());
        values.put("barcode_id",type.getText().toString());
        values.put("product",price.getText().toString());
        values.put("product_type",productType.getSelectedItem().toString());
        values.put("asset_state",assetState.getSelectedItem().toString());
        values.put("vendor",vendor.getSelectedItem().toString());
        values.put("asset_type",assetType.getSelectedItem().toString());
        values.put("asset_category",assetCategory.getText().toString());
        values.put("assogutation_gate",assocutationGate.getText().toString());
        values.put("expiry_date",expiryDate.getText().toString());
        values.put("serior_no",seriorNo.getText().toString());
        values.put("region",region.getText().toString());
        values.put("site",site.getText().toString());
        values.put("location",location.getText().toString());
        values.put("department",deparment.getText().toString());
        values.put("managed_by",managedBy.getText().toString());
        db.insert("product",null,values);
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
        assetCategory=findViewById(R.id.assetCategory);
        assocutationGate=findViewById(R.id.assocutationGate);
        expiryDate=findViewById(R.id.expiryDate);
        seriorNo=findViewById(R.id.seriorNo);
        region=findViewById(R.id.region);
        site=findViewById(R.id.site);
        location=findViewById(R.id.location);
        deparment=findViewById(R.id.deparment);
        managedBy=findViewById(R.id.managedBy);
        productType=findViewById(R.id.product_type);
        assetState=findViewById(R.id.asset_state);
        assetType=findViewById(R.id.asset_type);
        vendor=findViewById(R.id.vendor);
        submit=findViewById(R.id.submit);
    }
}
