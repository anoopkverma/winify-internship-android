package com.example.winify.cvsi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.mikepenz.materialdrawer.Drawer;

public class BaseActivity extends AppCompatActivity {

    private Bundle savedInstanceState;
    public NavigationDrawer nabDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_base);

    }

    @Override
    public void onBackPressed() {
        if (nabDrawer.getDrawer().isDrawerOpen()) {
            nabDrawer.getDrawer().closeDrawer();

        } else {
            super.onBackPressed();
        }
    }

    public NavigationDrawer getNabDrawer() {
        return this.nabDrawer;
    }


}

