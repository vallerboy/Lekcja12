package com.example.oskarpraca.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.icu.util.TimeUnit;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;


import java.util.Date;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity  {


    Database database;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        database = new Database(this);
    }



}
