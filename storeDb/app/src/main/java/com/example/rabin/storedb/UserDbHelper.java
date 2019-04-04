package com.example.rabin.storedb;

/**
 * Created by rabin on 4/3/2019.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/**
 * Created by rabin on 4/3/2019.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String Database_Name = "USERDB";
    private static final int Database_Version = 1;
    private static final String Create_Query =
            "CREATE TABLE " + UserContract.NewUserInfo.TABLE_NAME + "("+ UserContract.NewUserInfo.USER_NAME+" TEXT,"+
                    UserContract.NewUserInfo.ADDRESS+" TEXT);";

    public UserDbHelper(Context context)
    {
        super(context,Database_Name,null,Database_Version);
        Log.e("Database operations","Database created or opened");
    }

    public void onCreate(SQLiteDatabase dB) {
        dB.execSQL(Create_Query);
        Log.e("Database operations","Table created");

    }

    public void addInformation(String name,String address,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME, name);
        contentValues.put(UserContract.NewUserInfo.ADDRESS, address);
        //contentValues.put(UserContract.NewUserInfo.CONTACT, contact);
        db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("Database operations","one row is inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase dB, int i, int i1) {

    }
}
