package com.example.oskarpraca.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
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

    private LayoutInflater inflater;

    public BookAdapter(ArrayList<Book> books, Context con) {
        ourBooks = books;
        context = con;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return ourBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return ourBooks.get(position);
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
