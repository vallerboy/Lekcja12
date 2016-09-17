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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity  {


    Database database;

    @BindView(R.id.editAuthor)
    EditText author;

    @BindView(R.id.editCategory)
    EditText category;

    @BindView(R.id.editName)
    EditText name;

    @BindView(R.id.textCounter)
    TextView counterView;

    private int counter;


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        database = new Database(this);
        counter = 0;
    }


    @OnClick(R.id.buttonAdd)
    public void buttonAdd() {
        counter += 10;
        refreshTextView();
    }

    @OnClick(R.id.buttonMinus)
    public void buttonMinus(){
       if(counter > 10) {
           counter -= 10;
       }else {
           counter = 0;
       }
        refreshTextView();
    }

    @OnClick(R.id.buttonAdd)
    public void buttonAddBook(){
        database.addBook(new Book(name.getText().toString(), author.getText().toString(), category.getText().toString(), counter));
        Toast.makeText(this, "Dodałeś książkę", Toast.LENGTH_LONG).show();
    }


    private void refreshTextView(){
         counterView.setText(counter + "");
    }







}
