package com.example.manueleagzample.splashscreen.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;
import com.example.manueleagzample.splashscreen.service.LibraryService;

public class BookDetails extends AppCompatActivity {

    private LibraryBooks book;
    private boolean hasLoadedBook = false;

    private ImageView coverPage;
    private TextView title;
    private TextView author;
    private TextView publishingDate;
    private TextView edition;
    private TextView copiesAvailable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        initViews();
        Intent i = getIntent();
        if(i.hasExtra("BOOK_ID")) {
            book = LibraryService.getBookById(i.getStringExtra("BOOK_ID"));
            hasLoadedBook = true;
            if(hasLoadedBook) {
                populateViews();
            }
            Log.d(this.getClass().getSimpleName(), "Book is: "+book.toString());
        }
    }

    private void initViews() {
        coverPage = findViewById(R.id.cover_page);
        title = findViewById(R.id.book_title);
        author = findViewById(R.id.author_text);
        publishingDate = findViewById(R.id.date_of_publishing);
        edition = findViewById(R.id.edition);
        copiesAvailable = findViewById(R.id.copies_available);
    }

    private void populateViews() {
        title.setText(String.format("Title: %s", book.getTitle()));
        author.setText(String.format("Author: %s", book.getAuthor()));
        publishingDate.setText(String.format("Date of Publishing: N/A"));
        edition.setText(String.format("Edition: N/A"));
        copiesAvailable.setText(String.format("Copies: %d", book.getCount()));
    }
}
