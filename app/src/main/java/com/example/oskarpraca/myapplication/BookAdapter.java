package com.example.oskarpraca.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by OskarPraca on 2016-09-17.
 */
public class BookAdapter extends BaseAdapter {

    private  ArrayList<Book> ourBooks;
    private  MainActivity context;
    private  Database database;

    private LayoutInflater inflater;

    public BookAdapter(ArrayList<Book> books, MainActivity con, Database database) {
        ourBooks = books;
        context = con;
        this.database = database;
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

    public Book getBook(int id){
        return ourBooks.get(id);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder holder;

          if(view != null){
              holder = (ViewHolder) view.getTag();
          }else{
              view = inflater.inflate(R.layout.book_list, parent, false);
              holder = new ViewHolder(view);
              view.setTag(holder);
          }


        holder.name.setText(ourBooks.get(position).getName());
        holder.author.setText(ourBooks.get(position).getAuthor());


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.deleteBook(ourBooks.get(position).getName());
                context.resetAdapeter();
            }
        });


        return view;
    }

     static class ViewHolder{
        @BindView(R.id.textName)
        public TextView name;
        @BindView(R.id.textAuthor)
        public TextView author;
         @BindView(R.id.deleteButton)
         public Button delete;




         public ViewHolder(View v){
            ButterKnife.bind(this, v);
        }
    }
}
