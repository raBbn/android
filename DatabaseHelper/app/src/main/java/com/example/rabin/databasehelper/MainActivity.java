package com.example.rabin.databasehelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    private Button submit,view;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.user_name);
        submit = (Button)findViewById(R.id.store1);
        view = (Button)findViewById(R.id.view1);
        databaseHelper = new DatabaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = text.getText().toString();
                addInfo(newEntry);
                addInfo("");


            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addInfo(String name){
        boolean insertData = databaseHelper.addData(name);
        if(insertData){

        }
        else
        {

        }


    }
}
