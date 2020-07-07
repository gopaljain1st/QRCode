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
          String sql="create table item(id integer primary key AUTOINCREMENT,item_id varchar(100),name varchar(100),type varchar(100),price varchar(100),description varchar(500),date varchar(100))";
          sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
