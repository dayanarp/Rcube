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

public class MainActivityC extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_c);
        TextView compname = (TextView) findViewById(R.id.username);
        TextView compemail = (TextView) findViewById(R.id.useremail);
        TextView compphone = (TextView) findViewById(R.id.userphone);
        ImageView imgC = (ImageView) findViewById(R.id.imageView6);
        ImageView imgM = (ImageView) findViewById(R.id.imageView7);
        User user = AppData.getCurrentU();
        compname.setText(user.getName());
        compemail.setText(user.getEmail());
        compphone.setText(user.getPhone());
        Button btn = (Button) findViewById(R.id.send_button);
        Button btnE = (Button) findViewById(R.id.btn_edit);
        ArrayAdapter adapterC = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,AppData.getCities());
        ArrayAdapter adapterM = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,AppData.getMaterials());
        final Spinner spinnerC = (Spinner)findViewById(R.id.city);
        spinnerC.setAdapter(adapterC);
        final Spinner spinnerM = (Spinner)findViewById(R.id.material);
        spinnerM.setAdapter(adapterM);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityC.this, ListConv.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
