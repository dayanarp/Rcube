package com.example.dayana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_c);
        TextView compname = (TextView) findViewById(R.id.username);
        TextView compemail = (TextView) findViewById(R.id.useremail);
        TextView compphone = (TextView) findViewById(R.id.userphone);
        User user = AppData.getCurrentU();
        compname.setText(user.getName());
        compemail.setText(user.getEmail());
        compphone.setText(user.getPhone());
    }
}
