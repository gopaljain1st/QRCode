package com.example.cangoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cangoproject.adapters.SiteProjectAdapter;
import com.example.cangoproject.adapters.SiteTypeAdapter;
import com.example.cangoproject.models.SiteProjects;
import com.example.cangoproject.models.SiteType;

import java.util.ArrayList;

public class AssetTypeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SiteType> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_type);

        recyclerView=findViewById(R.id.rv);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new SiteType("12","Active Assets"));
        al.add(new SiteType("30","Passive Assets"));
        recyclerView.setAdapter(new SiteTypeAdapter(this,al));

    }
}
