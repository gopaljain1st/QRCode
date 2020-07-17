package com.example.cangoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivity extends AppCompatActivity {

    CardView cardView;
    TextView noOfAssest;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        noOfAssest=findViewById(R.id.noOfAssest);

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
        cardView = findViewById(R.id.card);
        cardView.setOnClickListener(new View.OnClickListener() {
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
