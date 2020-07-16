package com.example.cangoproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDataActivity extends AppCompatActivity 
{
    TextView id,name,type,price,assetCategory,assocutationGate,expiryDate,seriorNo,region,site,location,deparment,managedBy,productType,assetState,vendor,assetType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_data);
        initComponent();
        Product i= (Product) getIntent().getSerializableExtra("product");
        id.setText(i.getId());
        name.setText(i.getName());
        type.setText(i.getType());
        price.setText(i.getPrice());
        assetCategory.setText(i.getAssetCategory());
        assocutationGate.setText(i.getAssocutationGate());
        expiryDate.setText(i.getExpiryDate());
        seriorNo.setText(i.getSeriorNo());
        region.setText(i.getRegion());
        site.setText(i.getSite());
        location.setText(i.getLocation());
        deparment.setText(i.getDeparment());
        managedBy.setText(i.getManagedBy());
        assetType.setText(i.getAssetType());
        assetState.setText(i.getAssetState());
        productType.setText(i.getProductType());
        vendor.setText(i.getVendor());
    }

    private void initComponent()
    {
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        type=findViewById(R.id.type);
        price=findViewById(R.id.price);
        assetCategory=findViewById(R.id.assetCategory);
        assocutationGate=findViewById(R.id.assocutationGate);
        expiryDate=findViewById(R.id.expiryDate);
        seriorNo=findViewById(R.id.seriorNo);
        region=findViewById(R.id.region);
        site=findViewById(R.id.site);
        location=findViewById(R.id.location);
        deparment=findViewById(R.id.department);
        managedBy=findViewById(R.id.managedBy);
        productType=findViewById(R.id.productType);
        assetState=findViewById(R.id.assetState);
        assetType=findViewById(R.id.assetType);
        vendor=findViewById(R.id.vendor);
    }
}
