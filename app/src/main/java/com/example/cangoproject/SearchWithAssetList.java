package com.example.cangoproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;

public class SearchWithAssetList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<AssetModel> al;
    TextView filter,src_asset_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_with_asset_list);

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
        al.add(new AssetModel("RBS Cabinet","2544","1.00",R.drawable.qrcode));
        al.add(new AssetModel("Radio Unit","24","1.00",R.drawable.qrcode));
        al.add(new AssetModel("BB Unit","2544","1.00",0));
        al.add(new AssetModel("Antenna","25894","1.00",0));
        al.add(new AssetModel("Wireless Component","25894","1.00",R.drawable.qrcode));

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AssetAdapter(this,al));
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
