package com.example.oskarpraca.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

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


    public void addBook(Book book) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", book.getName());
        values.put("author", book.getAuthor());
        values.put("category", book.getCategory());
        values.put("pageCount", book.getPageCount());

        database.insertOrThrow("book", null, values);
    }

    public int getBooksNumber(){
        SQLiteDatabase database = getReadableDatabase();
     //   String[] columns = {"name, author, category, pageCount"};
        Cursor cursor = database.query("book", null, null, null, null, null, null);
        return cursor.getCount();
    }


    public ArrayList<Book> getAllBooks() {
        SQLiteDatabase database = getReadableDatabase();
        String[] columns = {"name, author, category, pageCount"};
        Cursor cursor = database.query("book", columns, null, null, null, null, null);

        ArrayList<Book> ourBooks =  new ArrayList<>();

         while (cursor.moveToNext()){
             ourBooks.add(new Book(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
         }

        return ourBooks;
    }

    public void deleteBook(String name){
        SQLiteDatabase database = getWritableDatabase();
        String[] args = {name};
        database.delete("book", "name=?", args);
    }
}
