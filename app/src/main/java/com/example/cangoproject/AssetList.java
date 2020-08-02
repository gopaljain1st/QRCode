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

import com.example.cangoproject.adapters.AssetAdapter;
import com.example.cangoproject.fragments.SearchBottomFragnment;
import com.example.cangoproject.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AssetList extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;

    TextView no;
    private ArrayList<Product> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset);
        no=findViewById(R.id.no);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Asset List");

        recyclerView=findViewById(R.id.rv);
        al=new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHelper helper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=helper.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("select * from product",null);
        while(c.moveToNext())
        {
            no.setVisibility(View.INVISIBLE);
            byte[] imgByte = c.getBlob(20);
            Bitmap image = BitmapFactory.decodeByteArray(imgByte,0,imgByte.length);
            al.add(new Product(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),
                    c.getString(8),c.getString(9),c.getString(10),c.getString(11),c.getString(12),c.getString(13),c.getString(14),c.getString(15),
                    c.getString(16),c.getString(17),c.getString(18),c.getString(19),image));
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AssetAdapter(this,al));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        //al=new ArrayList<>();
     //   readFromLocalStorage();
      //  adapter=new MyAdapter(this,al);
        //rv.setAdapter(adapter);



        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.site);

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
                        return true;
                    case R.id.search :
                        startActivity(new Intent(getApplicationContext(),SearchWithAssetList.class));
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),OutBox.class));
                        overridePendingTransition(0,0);
                        finish();
                        break;
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
   /* private void readFromLocalStorage()
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
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
