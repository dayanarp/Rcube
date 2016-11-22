package com.example.dayana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_u);
        TextView username = (TextView) findViewById(R.id.username);
        TextView useremail = (TextView) findViewById(R.id.useremail);
        TextView userphone = (TextView) findViewById(R.id.userphone);
        User user = AppData.getCurrentU();
        username.setText(user.getName());
        useremail.setText(user.getEmail());
        userphone.setText(user.getPhone());
    }
}
