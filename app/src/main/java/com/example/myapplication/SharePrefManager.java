package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharePrefManager {
    SharedPreferences sharedPreferences;
    static Contact contact;

    public static Contact getInstance(MainActivity mainActivity) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity);

    }

    //
//    public void getInstance(Context context) {
//
//    }
//
    public void saveContact(Contact contact) {
        this.contact = contact;
    }
}

