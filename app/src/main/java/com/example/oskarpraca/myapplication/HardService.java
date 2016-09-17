package com.example.oskarpraca.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by OskarPraca on 2016-09-17.
 */
public class HardService extends Service {

    Handler handler = new Handler();

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
            HardService getService() {
                return HardService.this;
            }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }



    public void sometingElse(){ }

    // metoda zapewniona
    public void createToast() {
       handler.post(new Runnable() {
           @Override
           public void run() {
               Toast.makeText(getApplicationContext(), "Ja znów z serwisu!", Toast.LENGTH_LONG).show();
           }
       });

    }
}
