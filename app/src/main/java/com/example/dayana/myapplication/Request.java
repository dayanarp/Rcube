package com.example.dayana.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Request extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        TextView username = (TextView) findViewById(R.id.username);
        TextView useremail = (TextView) findViewById(R.id.useremail);
        TextView userphone = (TextView) findViewById(R.id.userphone);
        ImageView imgC = (ImageView) findViewById(R.id.imageView6);
        ImageView imgM = (ImageView) findViewById(R.id.imageView7);
        Button btnE = (Button) findViewById(R.id.btn_edit);
        User user = AppData.getCurrentU();
        username.setText(user.getName());
        useremail.setText(user.getEmail());
        userphone.setText(user.getPhone());
        ArrayAdapter adapterC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,AppData.getQuant());
        ArrayAdapter adapterM = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,AppData.getUnit());
        final Spinner spinnerC = (Spinner)findViewById(R.id.quant);
        spinnerC.setAdapter(adapterC);
        final Spinner spinnerM = (Spinner)findViewById(R.id.unit);
        spinnerM.setAdapter(adapterM);
        Button btn = (Button) findViewById(R.id.send_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("Are you sure you want to send the request?");
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable.");
            }
        });
        imgC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerC.performClick();
            }
        });
        imgM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerM.performClick();
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
                finish();
                startActivity(new Intent(Request.this, Request.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        alertDialog.show();
    }

}
