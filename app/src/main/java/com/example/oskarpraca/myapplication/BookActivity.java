package com.example.oskarpraca.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookActivity extends AppCompatActivity {

    private String name, category, author;
    private String pageCount;

    @BindView(R.id.textName)
    TextView textName;

    @BindView(R.id.textAuthor)
    TextView textAuthor;

    @BindView(R.id.textCategory)
    TextView textCategory;

    @BindView(R.id.textNumber)
    TextView textNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        name = getIntent().getExtras().getString("name");
        category = getIntent().getExtras().getString("category");
        author = getIntent().getExtras().getString("author");
        pageCount = String.valueOf(getIntent().getExtras().getInt("pageCount"));

        textName.setText(name);
        textAuthor.setText(author);
        textCategory.setText(category);
        textNumber.setText(pageCount);
    }

    @OnClick(R.id.buttonBack)
    public void onClick(){
        super.onBackPressed();
    }

}
