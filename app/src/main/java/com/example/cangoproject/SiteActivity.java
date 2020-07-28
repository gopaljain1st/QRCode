package com.example.cangoproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SiteActivity extends AppCompatActivity
{
    Toolbar toolbar;
    RecyclerView rv;
    TextView selectedLine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_activity);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selectedLine=findViewById(R.id.selectedLine);
        rv=findViewById(R.id.rv);
    }
}
