package com.example.oskarpraca.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {


    @BindView(R.id.button)
    Button button;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

    }

    @OnClick(R.id.button)
    public void onClick(View v){

    }

}
