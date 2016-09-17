package com.example.oskarpraca.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by OskarPraca on 2016-09-17.
 */
public class Database  extends SQLiteOpenHelper{


    public Database(Context context) {
        super(context, "books.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE book(id integer primary key autoincrement, name text, author text, category text, pageCount integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // to wykona się, kiedy zmienimy wersje bazy danych w konstruktorze.
    }
}