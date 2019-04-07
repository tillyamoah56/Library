package com.example.manueleagzample.splashscreen.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.utils.PrefsManager;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ActionBar actionBar;
    private PrefsManager prefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefsManager = new PrefsManager(this);

        initViews();
        initDrawer();
        initListeners();
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black);
        }
    }

    private void initListeners() {
        navigationView.setNavigationItemSelectedListener(this);

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
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "E-books", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
