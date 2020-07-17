package com.example.cangoproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDataActivity extends AppCompatActivity 
{
    TextView id,name,type,price,assetCategory,assocutationGate,expiryDate,seriorNo,region,site,location,deparment,managedBy,productType,assetState,vendor,assetType;
    Product i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_data);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Details");
        initComponent();
         i= (Product) getIntent().getSerializableExtra("product");
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.qr,menu);
        MenuItem menuItem=menu.findItem(R.id.qr);
        menuItem.setOnMenuItemClickListener(
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem)
                    {
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
                        Intent intent=new Intent(ItemDataActivity.this,MainActivity.class);
                        intent.putExtra("data",message);
                        startActivity(intent);
                        return true;
                    }
                });
        return super.onCreateOptionsMenu(menu);
    }

}
