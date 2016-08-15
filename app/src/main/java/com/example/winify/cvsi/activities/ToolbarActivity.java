package com.example.winify.cvsi.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.example.winify.cvsi.R;

public class ToolbarActivity extends BaseActivity {

    public Toolbar toolbar;

    public void initToolbar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

