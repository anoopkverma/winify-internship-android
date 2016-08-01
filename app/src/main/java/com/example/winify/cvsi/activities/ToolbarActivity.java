package com.example.winify.cvsi.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.example.winify.cvsi.R;

public class ToolbarActivity extends BaseActivity {

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create a Borrow product");
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

