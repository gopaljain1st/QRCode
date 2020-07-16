package com.example.cangoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AssetList extends AppCompatActivity {

    RecyclerView rv;
    LinearLayoutManager manager;
    RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder>adapter;
    ArrayList<Product> al;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset);
        rv=findViewById(R.id.rv);
        text=findViewById(R.id.text);
        manager=new LinearLayoutManager(this);
        al=new ArrayList<>();
        readFromLocalStorage();
        rv.setLayoutManager(manager);
        adapter=new MyAdapter(this,al);
        rv.setAdapter(adapter);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Asset List");



        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.assetLst);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                    case R.id.assetLst:
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),Setting.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                }
                return false;
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    private void readFromLocalStorage()
    {
        DatabaseHelper helper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=helper.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("select * from product",null);
        while(c.moveToNext())
        {
            text.setVisibility(View.INVISIBLE);
            String id = c.getString(1);
            String name = c.getString(2);
            String type = c.getString(3);
            String price = c.getString(4);
            String productType = c.getString(5);
            String assetState = c.getString(6);
            String vendor = c.getString(7);
            String assetType = c.getString(8);
            String assetCategory = c.getString(9);
            String assocutationGate = c.getString(10);
            String expiryDate = c.getString(11);
            String seriorNo = c.getString(12);
            String region = c.getString(13);
            String site = c.getString(14);
            String location = c.getString(15);
            String department = c.getString(16);
            String managedBy = c.getString(17);
            al.add(new Product(id,name,type,price,productType,assetState,vendor,assetType,assetCategory,assocutationGate,expiryDate,seriorNo,region,site,location,department,managedBy));
        }
        c.close();
        helper.close();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
