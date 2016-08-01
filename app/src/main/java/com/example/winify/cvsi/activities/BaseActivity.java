package com.example.winify.cvsi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.NavDrawerController;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;

public class BaseActivity extends AppCompatActivity {

    private static Drawer drawer;
    private Bundle savendInstanceState1;
    private AccountHeader headerResult;
    private NavDrawerController navC = new NavDrawerController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savendInstanceState1 = savedInstanceState;
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
        navC.initBuilder(this, R.drawable.nina, savendInstanceState1);
    }
}
