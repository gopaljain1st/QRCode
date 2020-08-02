package com.example.cangoproject;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class FormActivity extends AppCompatActivity {

    TextView txtTransactionId,txtSerialNumber,txtQty,txtAssetId,txtTowerId,txtRadioUnitId,evedince;
    EditText etCabinetId,etRadioUnitBand,etRadioUnitPlacement,etRadioUnitType,etStatus,etAccepantance,etIntegration;
    private Uri filepath1,filepath2;
    String encodeImage;
    ImageView save;
    byte[] image= null;
    Bitmap bitmap, bitmap1;
    HashMap<String,String> hm;
    private String[] arr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        initComponent();
        Intent in=getIntent();
        String result=in.getStringExtra("result");
        hm = (HashMap<String, String>) in.getSerializableExtra("hm");
        arr=result.split(":|\\\n");
        try
        {
            txtTransactionId.setText(arr[1].trim());
            txtSerialNumber.setText(arr[3].trim());
            txtQty.setText(arr[5].trim());
            txtAssetId.setText(arr[7].trim());
            txtTowerId.setText(arr[9].trim());
            txtRadioUnitId.setText(arr[11].trim());

        }
        catch (Exception e)
        {
            txtTransactionId.setText(result);
        }
        ImageView back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image==null)
                {
                    Toast.makeText(FormActivity.this, "Please Select Evidence First", Toast.LENGTH_SHORT).show();
                }else if(etAccepantance.getText().toString().trim().equals("") || etCabinetId.getText().toString().trim().equals("") || etIntegration.getText().toString().trim().equals("") || etRadioUnitBand.getText().toString().trim().equals("") ||
                etRadioUnitPlacement.getText().toString().trim().equals("") || etRadioUnitType.getText().toString().trim().equals("") || etStatus.getText().toString().trim().equals(""))
                {
                    Toast.makeText(FormActivity.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                }
                else saveData();
            }
        });
        evedince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dexter.withActivity(FormActivity.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();

                            }

                        }).check();
            }

        });

    }

    private void saveData()
    {
        DatabaseHelper helper=new DatabaseHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("transaction_id",txtTransactionId.getText().toString());
        values.put("serial_no",txtSerialNumber.getText().toString());
        values.put("quantity",txtQty.getText().toString());
        values.put("asset_id",txtAssetId.getText().toString());
        values.put("tower_id",txtTowerId.getText().toString());
        values.put("radio_unit_id",txtRadioUnitId.getText().toString());
        values.put("cabinet_id",etCabinetId.getText().toString());
        values.put("radio_unit_band",etRadioUnitBand.getText().toString());
        values.put("radio_unit_placement",etRadioUnitPlacement.getText().toString());
        values.put("radio_unit_type",etRadioUnitType.getText().toString());
        values.put("status",etStatus.getText().toString());
        values.put("acceptance_date",etAccepantance.getText().toString());
        values.put("integration_date",etIntegration.getText().toString());
        values.put("project_code",hm.get("projectCode"));
        values.put("asset_type",hm.get("assetType"));
        values.put("domain",hm.get("domainId"));
        values.put("radio_asset_name",hm.get("radioName"));
        values.put("radio_asset_id",hm.get("radioId"));
        values.put("radio_asset_unit",hm.get("radioUnit"));
        values.put("image",image);
        db.insert("product",null,values);
        db.close();
        helper.close();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),SearchWithAssetList.class));
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            filepath1 = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(filepath1);
                bitmap = BitmapFactory.decodeStream(inputStream);
                bitmap=getResizedBitmap(bitmap,256);
                imageStore(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private void imageStore(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imageBytes = stream.toByteArray();
        image = imageBytes;
    }
    private void initComponent()
    {
        save = findViewById(R.id.save);

        //find all textview
        txtAssetId=findViewById(R.id.txtUseAssetId);
        txtQty=findViewById(R.id.txtUseQty);
        txtRadioUnitId=findViewById(R.id.txtUseRadioUnitId);
        txtSerialNumber=findViewById(R.id.txtUseSerial);
        txtTowerId=findViewById(R.id.txtUseTowerId);
        txtTransactionId=findViewById(R.id.txtUseTrans);

        //find all edittext
        etCabinetId=findViewById(R.id.cabinetid);
        etRadioUnitBand=findViewById(R.id.radio_unit_band);
        etRadioUnitPlacement=findViewById(R.id.radio_unit_placement);
        etRadioUnitType=findViewById(R.id.radio_unit_type);
        etStatus=findViewById(R.id.status);
        etAccepantance=findViewById(R.id.acceptance_date);
        etIntegration=findViewById(R.id.integration_date);

        //find imageview
        evedince=findViewById(R.id.evidence);
    }
}
