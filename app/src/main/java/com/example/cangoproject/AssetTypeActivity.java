package com.example.cangoproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.cangoproject.adapters.SiteProjectAdapter;
import com.example.cangoproject.adapters.SiteTypeAdapter;
import com.example.cangoproject.models.SiteProjects;
import com.example.cangoproject.models.SiteType;

import java.util.ArrayList;
import java.util.HashMap;

public class AssetTypeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SiteType> al;
    HashMap<String,String>hm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_type);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Asset Type");


        hm=new HashMap<>();
        Intent intent =getIntent();
        hm=(HashMap<String, String>) intent.getSerializableExtra("hm");
        recyclerView=findViewById(R.id.rv);
        al=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new SiteType("12","Active Assets"));
        al.add(new SiteType("30","Passive Assets"));
        recyclerView.setAdapter(new SiteTypeAdapter(this,al,hm));

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
