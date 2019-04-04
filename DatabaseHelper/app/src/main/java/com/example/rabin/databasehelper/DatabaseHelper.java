package com.example.rabin.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.Key;

/**
 * Created by rabin on 4/3/2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "people table";
    private static final String COL1 = "ID";
    private static final String COL2 = "Name";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + COL2 + "TEXT)";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item);
        Log.e("Operations","data added");

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result== -1)
            return false;
        else
            return true;
    }



}
