package com.example.manueleagzample.splashscreen.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {

    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String PREF_NAME = "LibraryApp";

    public PrefsManager(Context context) {
        int PRIVATE_MODE = 0;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setIsLoggedIn() {
        editor.putBoolean(IS_LOGGED_IN, true).apply();
    }

    public boolean getIsLoggedIn() {
        return preferences.getBoolean(IS_LOGGED_IN, false);
    }

    public void clearStorage() {
        editor.clear().apply();
    }
}
