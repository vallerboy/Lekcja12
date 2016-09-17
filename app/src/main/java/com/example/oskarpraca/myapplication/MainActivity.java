package com.example.oskarpraca.myapplication;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {



    private boolean isConnect;
    private HardService hardService;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonClick)
    public void onClick(View v){
        startService(new Intent(getBaseContext(), EasyService.class));
      //  stopService(new Intent(getBaseContext(), EasyService.class));
    }

    @OnClick(R.id.button)
    public void onClickHard(){
      if(isConnect) {
          hardService.createToast();
      }else{

      }
    }

    @Override
    public void onStart(){
        super.onStart();
        bindService(new Intent(this, HardService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onStop(){
        super.onStop();
        if(isConnect) {
            unbindService(mConnection);
            isConnect = false;
        }
    }



    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HardService.LocalBinder binder = (HardService.LocalBinder) service;
            hardService = binder.getService();
            isConnect = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
           isConnect = false;
        }
    };

}
