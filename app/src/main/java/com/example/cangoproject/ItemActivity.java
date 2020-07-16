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
        final Product i= (Product) getIntent().getSerializableExtra("product");
        data=findViewById(R.id.information);
        barcode=findViewById(R.id.barcode);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ItemActivity.this,ItemDataActivity.class);
                intent.putExtra("product",i);
                startActivity(intent);
            }
        });
        barcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message="";
                message+="Id :"+i.getId()+"\n";
                message+="NName : "+i.getName()+"\n";
                message+="Barcode ID : "+i.getType()+"\n";
                message+="Product : "+i.getPrice()+"\n";
                message+="Asset State : "+i.getAssetState()+"\n";
                message+="Vendor : "+i.getVendor()+"\n";
                message+="Asset Type : "+i.getAssetType()+"\n";
                message+="Asset Category : "+i.getAssetCategory()+"\n";
                message+="Assocutation Gate : "+i.getAssocutationGate()+"\n";
                message+="Expiry Date : "+i.getExpiryDate()+"\n";
                message+="Serior No : "+i.getSeriorNo()+"\n";
                message+="Region : "+i.getRegion()+"\n";
                message+="Site : "+i.getSite()+"\n";
                message+="Location : "+i.getLocation()+"\n";
                message+="Department : "+i.getDeparment()+"\n";
                message+="Managed By : "+i.getManagedBy()+"\n";
                Intent intent=new Intent(ItemActivity.this,MainActivity.class);
                intent.putExtra("data",message);
                startActivity(intent);
            }
        });
    }
}
