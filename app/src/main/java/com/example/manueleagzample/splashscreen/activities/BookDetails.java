package com.example.manueleagzample.splashscreen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;
import com.example.manueleagzample.splashscreen.service.LibraryService;
import com.example.manueleagzample.splashscreen.service.ReserveBookService;
import com.example.manueleagzample.splashscreen.utils.PrefsManager;

import java.util.Date;

public class BookDetails extends AppCompatActivity {

    private PrefsManager manager;

    private LibraryBooks book;
    private boolean hasLoadedBook = false;
    private Button button;

    private ImageView coverPage;
    private TextView title;
    private TextView author;
    private TextView publishingDate;
    private TextView edition;
    private TextView copiesAvailable;
    private ProgressBar loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        setTitle("Book Details");

        manager = new PrefsManager(this);

        initViews();
        Intent i = getIntent();
        if (i.hasExtra("BOOK_ID")) {
            book = LibraryService.getBookById(i.getStringExtra("BOOK_ID"));
            hasLoadedBook = true;
            if (hasLoadedBook) {
                populateViews();
                initListeners();
            }

        }
    }

    private void initViews() {
        coverPage = findViewById(R.id.cover_page);
        title = findViewById(R.id.book_title);
        author = findViewById(R.id.author_text);
        publishingDate = findViewById(R.id.date_of_publishing);
        edition = findViewById(R.id.edition);
        copiesAvailable = findViewById(R.id.copies_available);
        button = findViewById(R.id.reserve_button);
        loading = findViewById(R.id.loading);
    }

    private void populateViews() {
        title.setText(String.format("Title: %s", book.getTitle()));
        author.setText(String.format("Author: %s", book.getAuthor()));
        publishingDate.setText(String.format("Date of Publishing: N/A"));
        edition.setText(String.format("Edition: N/A"));
        copiesAvailable.setText(String.format("Copies: %d", book.getCount()));

        if (!book.isAvailable()) {
            button.setEnabled(false);
        }
    }

    private void initListeners() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loading.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Reserving book", Toast.LENGTH_LONG).show();


                String user = "user1";
                Date today = new Date();

                com.example.manueleagzample.splashscreen.models.ReservedBook bookToBeReserved = new com.example.manueleagzample.splashscreen.models.ReservedBook(book, user, today, null);

                String response = ReserveBookService.addReservedBook(bookToBeReserved);


                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                loading.setVisibility(View.GONE);
                if (response.equalsIgnoreCase("Book Reserved")) {
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            Intent i = new Intent(BookDetails.this, MainActivity.class);
                            startActivity(i);
                        }
                    }, 2000);

                }
            }
        });
    }
}
