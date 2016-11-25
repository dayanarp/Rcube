package com.example.dayana.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCorp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_corp);
        TextView username = (TextView) findViewById(R.id.username);
        TextView useremail = (TextView) findViewById(R.id.useremail);
        TextView userphone = (TextView) findViewById(R.id.userphone);
        ImageView iv1 = (ImageView) findViewById(R.id.imageView6);
        ImageView iv2 = (ImageView) findViewById(R.id.imageView7);
        ImageView iv3 = (ImageView) findViewById(R.id.imageView71);
        Button btnE = (Button) findViewById(R.id.btn_edit);
        User user = AppData.getCurrentU();
        username.setText(user.getName());
        useremail.setText(user.getEmail());
        userphone.setText(user.getPhone());
       iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListCorp.this, Request.class));
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListCorp.this, Request.class));
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListCorp.this, Request.class));
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
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
        alertDialog.show();
    }
}
