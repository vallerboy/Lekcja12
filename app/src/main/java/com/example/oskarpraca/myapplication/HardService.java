package com.example.oskarpraca.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by OskarPraca on 2016-09-17.
 */
public class HardService extends Service {


    public class LocalBinder extends Binder {
            HardService getService() {
                return HardService.this;
            }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
