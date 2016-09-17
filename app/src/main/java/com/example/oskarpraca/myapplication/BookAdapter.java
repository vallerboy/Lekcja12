package com.example.oskarpraca.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by OskarPraca on 2016-09-17.
 */
public class BookAdapter extends BaseAdapter {

    private  ArrayList<Book> ourBooks;
    private Context context;

    public BookAdapter(ArrayList<Book> books, Context con){
        ourBooks = books;
        context = con;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
