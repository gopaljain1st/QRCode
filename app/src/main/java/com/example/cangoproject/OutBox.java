package com.example.cangoproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.cangoproject.adapters.SiteTypeAdapter;
import com.example.cangoproject.adapters.SyncListAdapter;
import com.example.cangoproject.models.SiteType;
import com.example.cangoproject.models.SyncModel;

import java.util.ArrayList;

public class OutBox extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SyncModel> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_box);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Sync List");

        recyclerView=findViewById(R.id.sync_list);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        al.add(new SyncModel("RBS Cabinet","155535"));
        al.add(new SyncModel("BB Unit","89535"));
        al.add(new SyncModel("Radio Unit","49535"));
        al.add(new SyncModel("RBS Cabinet","12535"));
        recyclerView.setAdapter(new SyncListAdapter(this,al));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(OutBox.this,SiteActivity.class));
finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
