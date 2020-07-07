package com.example.cangoproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemActivity extends AppCompatActivity
{
    CardView data,barcode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        final Item i= (Item) getIntent().getSerializableExtra("item");
        data=findViewById(R.id.information);
        barcode=findViewById(R.id.barcode);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ItemActivity.this,ItemDataActivity.class);
                intent.putExtra("item",i);
                startActivity(intent);
            }
        });
        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Item> hm = new HashMap<>();
                hm.put("item",i);
                Gson gson = new Gson();
                final String jsonData = gson.toJson(hm);

                Intent intent=new Intent(ItemActivity.this,MainActivity.class);
                intent.putExtra("data",jsonData);
                startActivity(intent);
            }
        });
    }
}
