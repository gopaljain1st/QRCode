package com.example.cangoproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cangoproject.adapters.SiteProjectAdapter;
import com.example.cangoproject.fragments.SelectSiteNameBottomSheetDialog;
import com.example.cangoproject.models.SiteProjects;

import java.util.ArrayList;

public class SiteActivity extends AppCompatActivity
{
    Toolbar toolbar;
    RecyclerView rv;
    TextView selectedLine,siteName;
    ArrayList<SiteProjects>al;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_activity);
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
        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new SiteProjects(1,"01","32"));
        al.add(new SiteProjects(1,"02","42"));
        al.add(new SiteProjects(1,"03","22"));
        al.add(new SiteProjects(1,"04","12"));
        al.add(new SiteProjects(1,"05","52"));
        al.add(new SiteProjects(1,"06","64"));
        al.add(new SiteProjects(1,"07","32"));
        al.add(new SiteProjects(1,"08","42"));
        rv.setAdapter(new SiteProjectAdapter(this,al));
        rv.setNestedScrollingEnabled(false);
    }
}
