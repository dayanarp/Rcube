package rr.rcube;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {

    private boolean active = true;
    private int splashTime = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        Thread splash = new Thread() {
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
                    openApp();
                } catch (InterruptedException e) {
                }
            }
        };
        splash.start();
    }

    private void openApp(){
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }

}
