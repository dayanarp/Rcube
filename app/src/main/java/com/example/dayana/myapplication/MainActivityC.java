package com.example.dayana.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityC extends Activity {

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
        Button btn = (Button) findViewById(R.id.send_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainActivityC.this, ListConv.class));
            }
        });
    }
}
