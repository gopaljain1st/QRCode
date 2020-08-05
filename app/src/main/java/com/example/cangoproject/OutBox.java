package com.example.cangoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cangoproject.adapters.SiteTypeAdapter;
import com.example.cangoproject.adapters.SyncListAdapter;
import com.example.cangoproject.models.Product;
import com.example.cangoproject.models.SiteType;
import com.example.cangoproject.models.SyncModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class OutBox extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SyncModel> al;
    TextView txTPending;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_box);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Sync List");

        txTPending=findViewById(R.id.txtPending);

        recyclerView=findViewById(R.id.sync_list);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DatabaseHelper helper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=helper.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("select * from product",null);
        while(c.moveToNext())
        {
            count++;
            al.add(new SyncModel(c.getString(17),c.getString(18)));
        }

        txTPending.setText(String.valueOf(count)+" Assets Pending Sync");


      /*  al.add(new SyncModel("RBS Cabinet","155535"));
        al.add(new SyncModel("BB Unit","89535"));
        al.add(new SyncModel("Radio Unit","49535"));
        al.add(new SyncModel("RBS Cabinet","12535"));*/
        recyclerView.setAdapter(new SyncListAdapter(this,al));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.setting);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.site:
                        startActivity(new Intent(getApplicationContext(),SiteActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.list:
                        startActivity(new Intent(getApplicationContext(),AssetList.class));
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.search :
                        startActivity(new Intent(getApplicationContext(),SearchWithAssetList.class));
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.setting:
                        return true;
                }
                return false;
            }
        });

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
