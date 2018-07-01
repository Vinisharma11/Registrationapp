package com.example.user.registrationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username= findViewById(R.id.editText);
        final EditText password = findViewById(R.id.editText2);
        TextView textView=findViewById(R.id.textView);
        Button bt= findViewById(R.id.button);
        Button bt2= findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String passwor = password.getText().toString();
                SharedPreferences preferences = getSharedPreferences("myprefs", MODE_PRIVATE);

                String userdetails = preferences.getString(user + passwor +"data","username or password is incorrect");

                SharedPreferences.Editor editor= preferences.edit();

                editor.putString("display",userdetails);
                editor.commit();

                if(username.getText().toString().length() == 0 )
                    username.setError( "FIRST USERNAME IS REQUIRED" );
                if(password.getText().toString().length() == 0 )
                    password.setError( "FIRST PASSWORD IS REQUIRED" );

                else {
                    Intent intent = new Intent(MainActivity.this, prefrences.class);
                    startActivity(intent);
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registerationpage.class);
                startActivity(intent);


            }
        });

    }
}
