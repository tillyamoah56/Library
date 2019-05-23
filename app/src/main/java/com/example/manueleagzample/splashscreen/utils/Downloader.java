package com.example.manueleagzample.splashscreen.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.example.manueleagzample.splashscreen.models.LibraryBooks;

public class Downloader {

    public static void download(LibraryBooks book, Context context) {
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        String filename = book.getPdfURL().substring(book.getPdfURL().lastIndexOf('/')+1);

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(book.getPdfURL()));
        request.setTitle(book.getTitle());
        request.setDescription("Downloading...");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(true);

        if (manager != null) {
            manager.enqueue(request);
        }
    }
}
