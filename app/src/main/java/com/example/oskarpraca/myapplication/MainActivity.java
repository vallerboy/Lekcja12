package com.example.oskarpraca.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;


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

    @BindView(R.id.listView)
    ListView listView;

    private int counter;


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        database = new Database(this);
        counter = 0;

        listView.setAdapter(new BookAdapter(database.getAllBooks(), this, database));
    }


    @OnClick(R.id.buttonPlus)
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

    @OnClick(R.id.buttonAddBook)
    public void buttonAddBook(){
        database.addBook(new Book(name.getText().toString(), author.getText().toString(), category.getText().toString(), counter));
        resetAdapeter();
        Toast.makeText(this, "Dodałeś książkę", Toast.LENGTH_LONG).show();
    }


    private void refreshTextView(){
         counterView.setText(counter + "");
         Log.e("asd", counter + "");
    }


    public void resetAdapeter(){
        listView.deferNotifyDataSetChanged();
        listView.invalidateViews();
        listView.setAdapter(new BookAdapter(database.getAllBooks(), this, database));
    }

    @OnItemClick(R.id.listView)
    public void onItemClick(AdapterView<?> adapter, int position){
        Intent intent = new Intent(this, BookActivity.class);

        ArrayList<Book> books = database.getAllBooks();

        intent.putExtra("name", books.get(position).getName());
        intent.putExtra("category", books.get(position).getCategory());
        intent.putExtra("author", books.get(position).getAuthor());
        intent.putExtra("pageCount", books.get(position).getPageCount());

        startActivity(intent);
    }




}
