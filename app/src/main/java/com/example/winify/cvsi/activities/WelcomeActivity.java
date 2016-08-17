package com.example.winify.cvsi.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.controllers.UserController;

public class WelcomeActivity extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.getToken() != null) {
            getMainActivity();

        } else {
            getLoginActivity();
        }
    }

    public void getMainActivity() {
        Log.i("TAG", sessionManager.getToken());
        Intent getListItemsIntent = new Intent(this, ListItemsActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "SplashWelcomeActivity");
        startActivityForResult(getListItemsIntent, result);
    }

    public void getLoginActivity() {
        Intent getListItemsIntent = new Intent(this, LoginActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "SplashWelcomeActivity");
        startActivityForResult(getListItemsIntent, result);
    }
}
