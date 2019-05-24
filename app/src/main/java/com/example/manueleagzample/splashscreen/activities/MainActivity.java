package com.example.manueleagzample.splashscreen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.manueleagzample.splashscreen.Profile;
import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.adapters.BooksAdapter;
import com.example.manueleagzample.splashscreen.service.LibraryService;
import com.example.manueleagzample.splashscreen.utils.PrefsManager;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ActionBar actionBar;
    private PrefsManager prefsManager;
    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    private GridLayoutManager gridLayoutManager;
    private ProgressBar progressBar;
    private Toolbar toolbar;
//    private TextView loadingTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prefsManager = new PrefsManager(this);
        initViews();
        initDrawer();
        initListeners();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initAdapters();
            }
        }, 3000);
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black);
        }

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_circular);

//        loadingTextView = findViewById(R.id.textLoading);

        LibraryService.generateBooks();
    }

    private void initListeners() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initAdapters() {
        booksAdapter = new BooksAdapter(LibraryService.getAllLibraryBooks(), this);
        gridLayoutManager = new GridLayoutManager(this, 3, GridLayout.VERTICAL, false);

        recyclerView.setAdapter(booksAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        progressBar.setVisibility(View.GONE);
//        loadingTextView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void initDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.aug_reality:
                Toast.makeText(this, "Augmented Reality", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.library:
                Toast.makeText(this, "Library", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.borrowed_books:
                Toast.makeText(this, "Borrowed books", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.profile:
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.my_reserved_books:
                startActivity(new Intent(MainActivity.this, ReservedBook.class));
                Toast.makeText(this, "My Reserved books", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help_and_feedback:
                Toast.makeText(this, "Help and Feedback", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                prefsManager.clearStorage();
                goToLogin();
                finish();
                return true;
            case R.id.e_books:
                startActivity(new Intent(this, Ebooks.class));
                return true;
            default:
                return false;
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
//      used to inflate the menu resource
        inflater.inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                LibraryService.filterBooks(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
//this is where I implemented my search view

