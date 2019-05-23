package com.example.manueleagzample.splashscreen.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;
import com.example.manueleagzample.splashscreen.service.LibraryService;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;


public class EbookPreview extends AppCompatActivity {

    private LibraryBooks books;
    private WebView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_preview);

        initViews();

        Intent i = getIntent();
        if(i.hasExtra("E_BOOK_ID")) {
            this.books = LibraryService.getBookById(i.getStringExtra("E_BOOK_ID"));
            loadPDF();
        }
    }

    private void initViews() {
        pdfView = findViewById(R.id.pdfView);
        setTitle("Preview");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadPDF() {
        Uri bookUri =  Uri.parse(books.getPdfURL());


//        pdfView.getSettings().setJavaScriptEnabled(true);
        pdfView.loadUrl(books.getPdfURL());
//        pdfView.fromUri(bookUri)
//                .enableSwipe(true)
//                .autoSpacing(true)
//                .nightMode(true)
//                .onError(new OnErrorListener() {
//                    @Override
//                    public void onError(Throwable t) {
//                        Log.e("test1", t.getMessage());
//                        Log.e("test1", t.getLocalizedMessage());
//                        Log.e("test1", t.toString());
//                        Toast.makeText(getApplicationContext(), "Unable to load pdf. Please try again later", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .pageFitPolicy(FitPolicy.BOTH)
//                .load();
    }
}
