package com.example.manueleagzample.splashscreen.activities;

import android.Manifest;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.adapters.EbookAdapter;
import com.example.manueleagzample.splashscreen.models.LibraryBooks;
import com.example.manueleagzample.splashscreen.service.LibraryService;
import com.example.manueleagzample.splashscreen.utils.CheckForSDCard;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class Ebooks extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = Ebooks.class.getSimpleName();
    public static String pdfURL;

    private ArrayList<LibraryBooks> books;
    private RelativeLayout loadingContainer;
    private RecyclerView recyclerView;
    private EbookAdapter adapter;
    private LinearLayoutManager layoutManager;
    public static LibraryBooks book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);

        initViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initAdapters();
                recyclerView.setVisibility(View.VISIBLE);
                loadingContainer.setVisibility(View.GONE);
                checkAndDownloadPDF();
            }
        }, 2000);
    }

    private void initAdapters() {
        books = LibraryService.getEbooks();

        adapter = new EbookAdapter(books, this, this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.e_book_container);
        loadingContainer = findViewById(R.id.loading_container);

        setTitle("E-books");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void checkAndDownloadPDF() {
        if(CheckForSDCard.isSDCardPresent()) {
            PermissionListener listener = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
//                    Toast.makeText(Ebooks.this, "Permission Granted", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onPermissionDenied(List<String> deniedPermissions) {
                    Toast.makeText(Ebooks.this, "Permission Denied", Toast.LENGTH_LONG).show();
                }
            };

            TedPermission.with(this)
                    .setPermissionListener(listener)
                    .setDeniedMessage("If you deny this permission you cannot download the ebooks.\nPlease turn on permission at [Settings] > [Permissions]")
                    .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .check();
        }else {
            Toast.makeText(this, "SD Card not found", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
//        download(book);
        Log.d(TAG, "Permission granted");
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(TAG, "Permission has been denied");
    }
}
