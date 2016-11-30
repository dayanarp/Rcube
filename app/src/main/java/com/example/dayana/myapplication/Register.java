package com.example.dayana.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.HashMap;

public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RadioButton btnP = (RadioButton) findViewById(R.id.radioButton);
        RadioButton btnC = (RadioButton) findViewById(R.id.radioButton2);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText phone = (EditText) findViewById(R.id.tlf);
        final EditText pass = (EditText) findViewById(R.id.password);
        final EditText cpass = (EditText) findViewById(R.id.cpassword);
        Button btn = (Button) findViewById(R.id.send_button);
        String type = null;
        if(btnC.isChecked()){
            type = "C";
            btnP.setChecked(false);
        }
        if(btnP.isChecked()){
            type = "P";
            btnC.setChecked(false);
        }
        final String finalType = type;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(name, email, phone,pass,cpass, finalType);
            }
        });
    }

    private void attemptLogin(EditText name, EditText email, EditText phone, EditText pass, EditText cpass, String type){

        name.setError(null);
        email.setError(null);
        phone.setError(null);
        pass.setError(null);
        cpass.setError(null);

        String s_name = name.getText().toString();
        String s_email = email.getText().toString();
        String s_phone = phone.getText().toString();
        String s_pass = pass.getText().toString();
        String s_cpass = cpass.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if(TextUtils.isEmpty(s_name)){
            name.setError("This field can't be empty");
            focusView = name;
            cancel = true;
        }

        if(TextUtils.isEmpty(s_email)){
            email.setError("This field can't be empty");
            focusView = email;
            cancel = true;
        }

        if(TextUtils.isEmpty(s_phone)){
            phone.setError("This field can't be empty");
            focusView = phone;
            cancel = true;
        }

        if(TextUtils.isEmpty(s_pass)){
            pass.setError("This field can't be empty");
            focusView = pass;
            cancel = true;
        }

        if(TextUtils.isEmpty(s_cpass)){
            cpass.setError("This field can't be empty");
            focusView = cpass;
            cancel = true;
        }

        if(!s_pass.equals(s_cpass)){
            cpass.setError("Passwords must match");
            focusView = cpass;
            cancel = true;
        }

        if (cancel){
            focusView.requestFocus();
        } else{
            User newUser = new User(s_name, s_email,s_phone, s_pass, type);
            AppData.getUsers().put(s_email,s_pass);
            AppData.getUsersType().put(s_email,type);
            AppData.getUserList().add(newUser);
            AppData.getUserString().put(s_email,newUser);
            dialogCreateI("Se ha registrado exitosamente.");
        }
    }

    public void dialogCreateI(String message) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Information");
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                finish();
                startActivity(new Intent(Register.this, Login.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        alertDialog.show();
    }

}
