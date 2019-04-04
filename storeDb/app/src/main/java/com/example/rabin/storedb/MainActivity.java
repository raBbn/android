package com.example.rabin.storedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Context context;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addDB(View view)
    {
        EditText editText = findViewById(R.id.username);
        String user = editText.getText().toString();

        EditText editText1 = findViewById(R.id.address);
        String address = editText1.getText().toString();

        //  EditText editText2 = findViewById(R.id.phone);
        //String phone = editText2.getText().toString();

        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(user,address,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();

    }
}
