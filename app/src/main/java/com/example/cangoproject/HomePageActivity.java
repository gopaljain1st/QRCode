package com.example.cangoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blikoon.qrcodescanner.QrCodeActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {
    FloatingActionButton addAssert;
    TextView noOfAssest,txtmsg;
    SharedPreferences sharedPreferences;
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    private static final int REQUEST_CODE_QR_SCAN = 101;
    private void getEntries(){
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 2)); //values to go from  and to
        barEntries.add(new BarEntry(2f, 4)); //values to go from  and to
        barEntries.add(new BarEntry(3f, 5)); //values to go from  and to
        barEntries.add(new BarEntry(5f, 6)); //values to go from  and to
        barEntries.add(new BarEntry(7f, 2)); //values to go from  and to
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        barChart = findViewById(R.id.barChart);
        getEntries();

        barDataSet = new BarDataSet(barEntries, "Data Set");
        barData = new BarData(barDataSet);

        barChart.setData(barData);

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);


        noOfAssest=findViewById(R.id.noOfAssest);
        txtmsg=findViewById(R.id.txtmsg);
        sharedPreferences=getSharedPreferences("text",MODE_PRIVATE);

       if(sharedPreferences.getString("serialId","0").equals("0")){
           SharedPreferences.Editor editor=sharedPreferences.edit();
           editor.putString("serialId",""+1);
           editor.commit();
       }
       if(sharedPreferences.getString("assertCount","-1").equals("-1"))
       {
           SharedPreferences.Editor editor=sharedPreferences.edit();
           editor.putString("assertCount","0");
           editor.commit();
       }
       noOfAssest.setText(sharedPreferences.getString("assertCount","0"));
       noOfAssest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),AssetList.class));
           }
       });


        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Dashboard");
        addAssert = findViewById(R.id.addAsset);
        addAssert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, TestFlashLight.class));
            }
        });

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.dashboard:
                       return true;
                   case R.id.assetLst:
                       startActivity(new Intent(getApplicationContext(),AssetList.class));
                       overridePendingTransition(0,0);
                       return  true;
                   case R.id.setting:
                       startActivity(new Intent(getApplicationContext(),Setting.class));
                       overridePendingTransition(0,0);
                       return  true;

               }
               return false;
           }
       });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
       super.onBackPressed();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                Toast.makeText(this, contents, Toast.LENGTH_SHORT).show();
                Log.d("content",contents);
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
        /*if (resultCode != Activity.RESULT_OK) {
            Log.d("LOGTAG", "COULD NOT GET A GOOD RESULT.");
            if (data == null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("com.blikoon.qrcodescanner.error_decoding_image");
            if (result != null) {
                AlertDialog alertDialog = new AlertDialog.Builder(HomePageActivity.this).create();
                alertDialog.setTitle("Scan Error");
                alertDialog.setMessage("QR Code could not be scanned");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
            return;

        }
        if (requestCode == REQUEST_CODE_QR_SCAN) {
            if (data == null)
                return;
            //Getting the passed result
            String result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult");
            Log.d("LOGTAG", "Have scan result in your app activity :" + result);
            AlertDialog alertDialog = new AlertDialog.Builder(HomePageActivity.this).create();
            alertDialog.setTitle("Scan result");
            alertDialog.setMessage(result);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }*/
    }
}
