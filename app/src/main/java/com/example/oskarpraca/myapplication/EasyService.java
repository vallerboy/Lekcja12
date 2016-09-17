package com.example.oskarpraca.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by OskarPraca on 2016-09-17.
 */
public class EasyService extends IntentService {


    private Handler handler = new Handler();

    public EasyService() {
        super("EasyService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Powstałem z serwisu", Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
