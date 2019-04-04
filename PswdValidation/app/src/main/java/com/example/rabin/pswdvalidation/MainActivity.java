package com.example.rabin.pswdvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user_name,user_pswd;
    private ImageButton check_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = findViewById(R.id.user);
        user_pswd = findViewById(R.id.pswd);
        check_btn = findViewById(R.id.button);



        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = user_name.getText().toString();
                String pswd = user_pswd.getText().toString();

                if (user.length() != 0)
                {
                    if(user.contains("#"))
                    {
                        Toast.makeText(getApplicationContext(),"cant use #",Toast.LENGTH_SHORT).show();
                        user_name.requestFocus();
                    }
                    else if (pswd.length()<=6)
                    {
                        Toast.makeText(getApplicationContext(),"Password cant be less than length 6",Toast.LENGTH_SHORT).show();
                        user_pswd.setError("enter password correctly");
                        user_pswd.requestFocus();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Success in Operation",Toast.LENGTH_SHORT).show();
                    }

                }

                else
                {
                    Toast.makeText(getApplicationContext(),"cant be null",Toast.LENGTH_SHORT).show();
                    user_name.requestFocus();
                }

            }
        });


    }
}
