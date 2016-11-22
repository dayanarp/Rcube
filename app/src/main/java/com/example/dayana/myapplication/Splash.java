package com.example.dayana.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private boolean active = true;
    private int splashTime = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (active && (waited < splashTime)) {
                        sleep(1);
                        if (active) {
                            waited += 1;
                        }
                    }
                } catch (InterruptedException e) {
                } finally {
                    openApp();
                }
            }
        };
        splashThread.start();
    }

    private void openApp(){
        User user = new User("Roberto Romero", "robertoromero@gmail.com", "04123453443","1234","P");
        User comp = new User("Romero & Rodrigues Corp.", "info@randr.com", "0500-456543", "4321", "C");
        AppData.getUserString().put("Roberto Romero", user);
        AppData.getUserString().put("Romero & Rodrigues Corp.",comp);
        AppData.getUserList().add(user);
        AppData.getUserList().add(comp);
        AppData.getUsers().put("Roberto Romero","1234");
        AppData.getUsers().put("Romero & Rodrigues Corp.","4321");
        AppData.getUsersType().put("Romero & Rodrigues Corp.","C");
        AppData.getUsersType().put("Roberto Romero", "P");
        finish();
        startActivity(new Intent(this, Login.class));
    }
}
