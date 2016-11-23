package com.example.dayana.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Splash extends Activity {

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
        User user = new User("Roberto Romero", "randr@gmail.com", "04123453443","1234","P");
        User comp = new User("Romero & Rodrigues Corp.", "info@randr.com", "0500-456543", "4321", "C");
        HashMap<String, User> m = new HashMap();
        HashMap<String, String> m1 = new HashMap<>();
        HashMap<String, String> m2 = new HashMap<>();
        List<User> l = new ArrayList<>();
        m.put("randr@gmail.com", user);
        m.put("info@randr.com",comp);
        AppData.setUserString(m);
        l.add(user);
        l.add(comp);
        AppData.setUserList(l);
        m1.put("randr@gmail.com","1234");
        m1.put("info@randr.com","4321");
        AppData.setUsers(m1);
        m2.put("info@randr.com","C");
        m2.put("randr@gmail.com", "P");
        AppData.setUsersType(m2);
        finish();
        startActivity(new Intent(this, Login.class));
    }
}
