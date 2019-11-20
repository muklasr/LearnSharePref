package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharePrefManager {
    SharedPreferences sharedPreferences;
    static Contact contact;

    public static SharePrefManager getInstance(MainActivity mainActivity) {
        SharedPreferences mSettings = mainActivity.getSharedPreferences("SP", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity);
        return sharedPreferences;
    }

    //
//    public void getInstance(Context context) {
//
//    }
//
    public void saveContact(Contact contact) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",contact.getName());
        editor.putString("Phone",contact.getPhone());
        editor.putString("Address",contact.getAddress());
        editor.apply();
    }
    public Contact getContact() {
        Contact contact = new Contact(sharedPreferences.getString("Name",null),sharedPreferences.getString("Phone",null),sharedPreferences.getString("Address",null));
        return contact;
    }
}

