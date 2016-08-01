package com.example.winify.cvsi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.NavDrawerController;

public class BaseActivity extends AppCompatActivity {

    private Bundle savedInstanceState;
    private NavDrawerController navC = new NavDrawerController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_base);
    }

    @Override
    public void onBackPressed() {
        if (navC.getDrawer().isDrawerOpen()) {
            navC.getDrawer().closeDrawer();

        } else {
            super.onBackPressed();
        }
    }

    public void initNavDrawer() {
        navC.initBuilder(this, R.drawable.nina, savedInstanceState);
    }
}

