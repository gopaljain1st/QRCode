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
import com.example.cangoproject.adapters.DomainAdapter;
import com.example.cangoproject.fragments.SearchBottomFragnment;
import com.example.cangoproject.fragments.SelectSiteNameBottomSheetDialog;
import com.example.cangoproject.models.AssetModel;
import com.example.cangoproject.models.Domian;
import com.example.cangoproject.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SearchWithAssetList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Product> al;
    TextView filter,src_asset_type,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_with_asset_list);
        no=findViewById(R.id.no);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Asset List");

        recyclerView=findViewById(R.id.recycle_asset);
        al=new ArrayList<>();

        filter=findViewById(R.id.filter);
        src_asset_type=findViewById(R.id.src_asset_type);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SearchBottomFragnment().show(getSupportFragmentManager(),"Dialog");
            }
        });

        src_asset_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SearchBottomFragnment().show(getSupportFragmentManager(),"Dialog");
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        al=new ArrayList<>();
        /*DatabaseHelper helper=new DatabaseHelper(this);
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
        /*al.add(new AssetModel("RBS Cabinet","2544","1.00",R.drawable.qrcode));
        al.add(new AssetModel("Radio Unit","24","1.00",R.drawable.qrcode));
        al.add(new AssetModel("BB Unit","2544","1.00",0));
        al.add(new AssetModel("Antenna","25894","1.00",0));
        al.add(new AssetModel("Wireless Component","25894","1.00",R.drawable.qrcode));
*/
      /*  recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AssetAdapter(this,al));*/
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
                        return true;
                    case R.id.list:
                        startActivity(new Intent(getApplicationContext(),AssetList.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.search :
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),OutBox.class));
                        overridePendingTransition(0,0);
                        finish();
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
          startActivity(new Intent(SearchWithAssetList.this,SiteActivity.class));
           finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
