package com.example.oskarpraca.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements LocationListener {


    private LocationManager locationManager;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e("GPS", "Brkauje permission");
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0.1f, this);
    }


    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "Zmieniono lokaliacje", Toast.LENGTH_LONG).show();
        Log.e("GPS", "Zmieniono lokalalizacje");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Uruchomiono GPS", Toast.LENGTH_LONG).show();
        Log.e("GPS", "Uruchomiono GPS");
    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
