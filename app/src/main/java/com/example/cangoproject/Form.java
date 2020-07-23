package com.example.cangoproject;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.maps.android.SphericalUtil;

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
    TextView latitude,longitude;
    Location currentLocation;
    boolean flag=false;
    private static  final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    FusedLocationProviderClient fusedLocationProviderClient;
    String arr[];
    LatLng qrCodeLocation,curLocation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        initComponent();
        Intent in=getIntent();
        String result=in.getStringExtra("result");
        SharedPreferences sp=getSharedPreferences("text",MODE_PRIVATE);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        fetchLastLocatin();
        seriorNo.setText(sp.getString("serialId","0"));
        arr=result.split(":|\\\n");
        try
        {
              id.setText(arr[1].trim());
              name.setText(arr[3].trim());
              type.setText(arr[5].trim());
              price.setText(arr[7].trim());
              latitude.setText("Latitude : "+arr[9].trim());
              longitude.setText("Longitude : "+arr[11].trim());
              qrCodeLocation=new LatLng(Double.parseDouble(arr[9]),Double.parseDouble(arr[11]));

        }
        catch (Exception e)
        {
            id.setText(result);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(!flag)
                {
                    androidx.appcompat.app.AlertDialog.Builder dialog = new AlertDialog.Builder(Form.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Please Give Permission To Access Current Location");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            if(ActivityCompat.checkSelfPermission(Form.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                                ActivityCompat.requestPermissions(Form.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_LOCATION_PERMISSION);
                            }
                        }
                    });
                    dialog.create();
                    dialog.show();
                }
                else
                {

                    double dis  = SphericalUtil.computeDistanceBetween(qrCodeLocation,curLocation);
                    if((dis/1000)>2.0)
                    {
                        androidx.appcompat.app.AlertDialog.Builder dialog = new AlertDialog.Builder(Form.this);
                        dialog.setTitle("Sorry");
                        dialog.setMessage("Your Distance Is "+(dis/1000)+"Km Which is Greater Than 2.0Km");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }
                        });
                        dialog.create();
                        dialog.show();
                    }
                    else
                    {
                        saveToLocalStorage();
                    }
                }
            }
        });
    }
    private void fetchLastLocatin() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_LOCATION_PERMISSION);
            return;
        }

        Task<Location> task=fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    flag=true;
                    currentLocation=location;
                    curLocation=new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
                    //latitude.setText("Latitude : "+currentLocation.getLatitude());
                    //longitude.setText("Longitude : "+currentLocation.getLongitude());
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_LOCATION_PERMISSION:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    flag=true;
                    fetchLastLocatin();
                }
                break;
        }
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
        SharedPreferences sp =getSharedPreferences("text",MODE_PRIVATE);
        String count=sp.getString("assertCount","0");
        String sNo=sp.getString("serialId","0");
        int serialNo=Integer.parseInt(sNo);
        serialNo+=1;
        int i=Integer.parseInt(count);
        i+=1;
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("assertCount",""+i);
        editor.putString("serialId",""+serialNo);
        editor.commit();
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
        latitude=findViewById(R.id.latitude);
        longitude=findViewById(R.id.longitude);
    }
}
