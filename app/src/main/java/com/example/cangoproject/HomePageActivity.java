package com.example.cangoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
       txtmsg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               noOfAssest.callOnClick();
           }
       });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Dashboard");
        addAssert = findViewById(R.id.addAssert);
        addAssert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
                finish();
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
                       finish();
                       return  true;
                   case R.id.setting:
                       startActivity(new Intent(getApplicationContext(),Setting.class));
                       overridePendingTransition(0,0);
                       finish();
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
}
