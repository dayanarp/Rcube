package com.example.dayana.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListConv extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_conv);
        TextView username = (TextView) findViewById(R.id.username);
        TextView useremail = (TextView) findViewById(R.id.useremail);
        TextView userphone = (TextView) findViewById(R.id.userphone);
        Button btnE = (Button) findViewById(R.id.btn_edit);
        ImageView i1 = (ImageView) findViewById(R.id.imageView1);
        ImageView i2 = (ImageView) findViewById(R.id.imageView7);
        ImageView i3 = (ImageView) findViewById(R.id.imageView2);
        ImageView i4 = (ImageView) findViewById(R.id.imageView6);
        ImageView i5 = (ImageView) findViewById(R.id.imageView71);
        ImageView i6 = (ImageView) findViewById(R.id.imageView3);
        User user = AppData.getCurrentU();
        username.setText(user.getName());
        useremail.setText(user.getEmail());
        userphone.setText(user.getPhone());
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });

    }

    public void dialogCreate(String message) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Information");
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });


    }
}