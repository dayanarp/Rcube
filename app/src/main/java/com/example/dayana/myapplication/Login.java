package com.example.dayana.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText user = (EditText) findViewById(R.id.email);
        final EditText pass = (EditText) findViewById(R.id.password);
        TextView textP = (TextView) findViewById(R.id.textViewP);
        Button btn = (Button) findViewById(R.id.email_sign_in_button);
        TextView join = (TextView) findViewById(R.id.textViewJ);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin(user, pass);
            }
        });
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        textP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCreate("This feature is not avaiable");
            }
        });
    }


    private void attemptLogin(EditText user, EditText pass){

        user.setError(null);
        pass.setError(null);

        String s_user = user.getText().toString();
        String s_pass = pass.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if(TextUtils.isEmpty(s_user)){
            user.setError("This field can't be empty");
            focusView = user;
            cancel = true;
        }

        if(TextUtils.isEmpty(s_pass)){
            pass.setError("This field can't be empty");
            focusView = pass;
            cancel = true;
        }

        if (cancel){
            focusView.requestFocus();
        } else{
            boolean isUser = checkUser(s_user, s_pass);
            if (isUser){
                HashMap t = AppData.getUsersType();
                User u = AppData.getUserString().get(s_user);
                AppData.setCurrentU(u);
                if(t.get(s_user) == "P"){
                    startActivity(new Intent(this, MainActivityU.class));
                }
                else {
                    startActivity(new Intent(this, MainActivityC.class));
                }
            } else {
                dialogCreate("Invalid user or password.");
            }
        }
    }

    private boolean checkUser(String user, String pass){
        boolean b = false;
        HashMap u = AppData.getUsers();
        if (u.containsKey(user)){
            String y = (String) u.get(user);
            if(y.equals(pass)){
                b = true;
            }
        }
        return b;
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
