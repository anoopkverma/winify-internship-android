package com.example.winify.cvsi.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.winify.cvsi.JsonMarshaller;
import com.example.winify.cvsi.model.User;

/**
 * Created by diana on 8/17/16.
 */
public class SessionManager {

    private final static String TAG = "SessionManager";
    public final static String TOKEN = "TOKEN";
    public final static String CACHE = "CACHE";
    private final static String USER = "USER";
    Context context;
    SharedPreferences sharedPreferences;


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(CACHE, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        sharedPreferences.edit().putString(TOKEN, token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public void saveUser(User responseUser) {
        try {
            sharedPreferences.edit().putString(USER, JsonMarshaller.toJson(responseUser)).apply();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public User getUser() {
        String jsonData = sharedPreferences.getString(USER, null);
        if (jsonData != null) {
            try {
                return JsonMarshaller.fromJson(User.class, jsonData);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return null;
    }

    public void logout() {
        sharedPreferences.edit().putString(TOKEN, null).apply();
    }
}
