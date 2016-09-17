package com.example.oskarpraca.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BookActivity extends AppCompatActivity {

    private String name, category, author;
    private Integer pageCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        name = getIntent().getExtras().getString("name");
        category = getIntent().getExtras().getString("category");
        author = getIntent().getExtras().getString("author");


        pageCount = getIntent().getExtras().getInt("pageCount");


    }
}
