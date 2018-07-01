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

public class registerationpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerationpage);
        final EditText name= findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText password= findViewById(R.id.password);
        Button bt3= findViewById(R.id.register);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myprefs",MODE_PRIVATE);
                String newUser=name.getText().toString();
                String newPasswords= password.getText().toString();
                String newEmail=email.getText().toString();

                SharedPreferences.Editor editor= preferences.edit();
                editor.putString(newUser +newPasswords+"data",newUser+"\n"+newEmail);
                editor.commit();

                Intent i= new Intent(registerationpage.this,MainActivity.class);
                startActivity(i);

            }
        });
    }

}
