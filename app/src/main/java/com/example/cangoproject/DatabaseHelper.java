package com.example.cangoproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
   public DatabaseHelper(Context context)
    {
        super(context,"test.sqlite",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
         // String sql="create table product(id integer primary key AUTOINCREMENT,item_id varchar(100),n_name varchar(100),barcode_id varchar(100),product varchar(100),product_type varchar(100),asset_state varchar(100),vendor varchar(100) , asset_type varchar(100),asset_category varchar(100), assogutation_gate varchar(100) , expiry_date varchar(100),serior_no varchar(100), region varchar(100), site varchar(100), location varchar(100) , department varchar(100), managed_by varchar(100))";
            String sql="create table product(id integer primary key AUTOINCREMENT,transaction_id varchar(100),serial_no varchar(100),quantity varchar(100),asset_id varchar(100),tower_id varchar(100),radio_unit_id varchar(100),cabinet_id varchar(100) , radio_unit_band varchar(100),radio_unit_placement varchar(100), radio_unit_type varchar(100) , status varchar(100),acceptance_date varchar(100), integration_date varchar(100), project_code varchar(100), asset_type varchar(100) ,domain varchar(100), radio_assets varchar(100),image BLOB)";
            sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
