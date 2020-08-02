package com.example.cangoproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.cangoproject.adapters.DomainAdapter;
import com.example.cangoproject.adapters.RadioAdapter;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.Radio;

import java.util.ArrayList;
import java.util.HashMap;

public class RadioAsset extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Radio> al;
    HashMap<String,String>hm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_asset);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Radio Asset");

        hm=(HashMap<String, String>) getIntent().getSerializableExtra("hm");
        recyclerView=findViewById(R.id.rv);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new Radio("RBS Cabinet","NE ID : 252555","1.0"));
        al.add(new Radio("Radio Unit","NE ID : 289555","1.0"));
        al.add(new Radio("BB Cabinet","NE ID : 259786","1.0"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RadioAdapter(this,al,hm));

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
