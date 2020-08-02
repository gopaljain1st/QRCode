package com.example.cangoproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cangoproject.adapters.FragAdapter;
import com.example.cangoproject.models.Product;
import com.google.android.material.tabs.TabLayout;

public class DetailsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TextView txtTransactionId,txtSerialNumber,txtQty;
    ImageView qrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txtQty=findViewById(R.id.txtUseQty);
        txtSerialNumber=findViewById(R.id.txtUseSerial);
        txtTransactionId=findViewById(R.id.txtUseTrans);
        qrCode=findViewById(R.id.qrCode);

        final Product p = (Product) getIntent().getSerializableExtra("product");
        Bundle bundle = getIntent().getExtras();
        byte[] byteArray = bundle.getByteArray("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0 , byteArray.length);
        qrCode.setImageResource(R.drawable.qrcode);

        txtQty.setText(p.getQuantity());
        txtSerialNumber.setText(p.getSerialNo());
        txtTransactionId.setText(p.getTransactionId());
        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="";
                message+="Transaction Id : "+p.getTransactionId()+"\n";
                message+="Serial Number : "+p.getSerialNo()+"\n";
                message+="Quantity : "+p.getQuantity()+"\n";
                message+="Asset Id : "+p.getAssetId()+"\n";
                message+="Tower Id : "+p.getTowerId()+"\n";
                message+="Radio Unit Id : "+p.getRadioUnitId()+"\n";
                message+="Cabinet Id : "+p.getCabinetId()+"\n";
                message+="Radio Unit Band : "+p.getRadioUnitBand()+"\n";
                message+="Radio Unit Placement : "+p.getRadioUnitPlacement()+"\n";
                message+="Radio Unit Type : "+p.getRadioUnitType()+"\n";
                message+="Status : "+p.getStatus()+"\n";
                message+="Acceptance Date : "+p.getAcceptanceDate()+"\n";
                message+="Integration Date : "+p.getIntegrationDate()+"\n";
                message+="Project Code : "+p.getProjectCode()+"\n";
                message+="Asset Type : "+p.getAssetType()+"\n";
                message+="Domain Id : "+p.getDomainId()+"\n";
                message+="Radio Asset Id : "+p.getRadioId()+"\n";
                message+="Radio Asset Name : "+p.getRadioName()+"\n";
                message+="Radio Asset Unit : "+p.getRadioUnit();
                Intent intent=new Intent(DetailsActivity.this,MainActivity.class);
                intent.putExtra("data",message);
                startActivity(intent);
            }
        });
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Asset Details");


        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);


        tabLayout.addTab(tabLayout.newTab().setText("DETAILS"));
        tabLayout.addTab(tabLayout.newTab().setText("PICTURE"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        Product product = p;
        final FragAdapter myAdapter=new FragAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount(),product,bitmap);
        viewPager.setAdapter(myAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
