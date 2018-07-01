package com.example.user.registrationapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class prefrences extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefrence);
        TextView TXT=(TextView) findViewById(R.id.TEXTVIEW);

        SharedPreferences preferences = getSharedPreferences("myprefs",MODE_PRIVATE);
        String display = preferences.getString("display","");
        TextView displayInfo =(TextView) findViewById(R.id.textView3);
        displayInfo.setText(display);

        Button btn= findViewById(R.id.logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(prefrences.this,MainActivity.class);
                startActivity(it);
            }
        });

    }
}
