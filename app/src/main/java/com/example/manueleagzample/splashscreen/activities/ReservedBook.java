package com.example.manueleagzample.splashscreen.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.adapters.ReserveBookAdapter;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;
import com.example.manueleagzample.splashscreen.service.ReserveBookService;

import java.util.ArrayList;
import java.util.Date;

public class ReservedBook extends AppCompatActivity {

    private ReserveBookAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RelativeLayout noReservedBooksContainer;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_books);

        setTitle("Reserved Books");
        initViews();
        Log.d(this.getClass().getSimpleName(), ReserveBookService.getAllReserveBook().toString());
        initAdapters();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        noReservedBooksContainer = findViewById(R.id.no_reserved_book_container);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initAdapters() {
        adapter = new ReserveBookAdapter(this, ReserveBookService.getAllReserveBook());
        layoutManager = new LinearLayoutManager(this);

        if(ReserveBookService.getAllReserveBook().size() == 0) {
            recyclerView.setVisibility(View.GONE);
            noReservedBooksContainer.setVisibility(View.VISIBLE);
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}