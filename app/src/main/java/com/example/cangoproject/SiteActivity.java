package com.example.cangoproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.adapters.SiteProjectAdapter;
import com.example.cangoproject.fragments.SelectSiteNameBottomSheetDialog;
import com.example.cangoproject.models.SiteProjects;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SiteActivity extends AppCompatActivity
{
    Toolbar toolbar;
    RecyclerView rv;
    TextView selectedLine,siteName;
    ArrayList<SiteProjects>al;
    FloatingActionButton addAssert;
    int id=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_activity);
        id=getIntent().getIntExtra("id",1);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selectedLine=findViewById(R.id.selectedLine);
        siteName=findViewById(R.id.siteName);
        siteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new SelectSiteNameBottomSheetDialog().show(getSupportFragmentManager(),"Dialog");
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
            }
        }


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.site);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.site:
                        return true;
                    case R.id.list:
                        startActivity(new Intent(getApplicationContext(),AssetList.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.search :
                        startActivity(new Intent(getApplicationContext(),SearchWithAssetList.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),OutBox.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        }); /*
      *
      *   addAssert = findViewById(R.id.addAsset);
        addAssert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SiteActivity.this, TestFlashLight.class));
            }
        });
        * */

        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        if(id==1)
        {
            al.add(new SiteProjects(1,"01","32"));
            al.add(new SiteProjects(1,"02","42"));
            al.add(new SiteProjects(1,"03","22"));
            al.add(new SiteProjects(1,"04","12"));
            al.add(new SiteProjects(1,"05","52"));
            al.add(new SiteProjects(1,"06","64"));
            al.add(new SiteProjects(1,"07","32"));
            al.add(new SiteProjects(1,"08","42"));
        }
        else if(id==2)
        {
            al.add(new SiteProjects(1,"09","45"));
            al.add(new SiteProjects(1,"10","42"));
            al.add(new SiteProjects(1,"11","15"));
            al.add(new SiteProjects(1,"12","12"));
            al.add(new SiteProjects(1,"13","52"));
            al.add(new SiteProjects(1,"14","64"));
            al.add(new SiteProjects(1,"15","32"));
            al.add(new SiteProjects(1,"16","42"));
        }
        else if(id==3)
        {
            al.add(new SiteProjects(1,"77","55"));
            al.add(new SiteProjects(1,"25","98"));
            al.add(new SiteProjects(1,"45","09"));
            al.add(new SiteProjects(1,"20","02"));
        }
        else if(id==4)
        {
            al.add(new SiteProjects(1,"17","32"));
            al.add(new SiteProjects(1,"18","42"));
            al.add(new SiteProjects(1,"19","22"));
            al.add(new SiteProjects(1,"21","12"));
        }
        rv.setAdapter(new SiteProjectAdapter(this,al));
        rv.setNestedScrollingEnabled(false);
    }
}
