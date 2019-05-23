package com.example.manueleagzample.splashscreen.utils;

import android.os.Environment;

public class CheckForSDCard {

    public static boolean isSDCardPresent() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

    }

}
