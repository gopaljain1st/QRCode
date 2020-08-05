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

import com.example.cangoproject.adapters.DomainAdapter;
import com.example.cangoproject.adapters.SiteProjectAdapter;
import com.example.cangoproject.adapters.SiteTypeAdapter;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.SiteProjects;
import com.example.cangoproject.models.SiteType;

import java.util.ArrayList;
import java.util.HashMap;

public class AssetTypeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Domian> al;
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
        al.add(new Domian("Genset","Trx : 20","1.00"));
        al.add(new Domian("Air Conditioner","Trx ID : 25","1.00"));
        al.add(new Domian("Rectifier","Trx ID : 28","1.00"));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DomainAdapter(this,al,hm));
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
