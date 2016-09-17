package com.example.oskarpraca.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public View getView(int position, View view, ViewGroup parent) {

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


        return view;
    }

     static class ViewHolder{
        @BindView(R.id.textName)
        public TextView name;
        @BindView(R.id.textAuthor)
        public TextView author;

        public ViewHolder(View v){
            ButterKnife.bind(this, v);
        }
    }
}
