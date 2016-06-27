package com.example.winify.cvsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BuyItemPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_preview);

        if (getIntent().hasExtra(BuyAdapter.BUY_POST)) {
            String temp = getIntent().getExtras().getString(BuyAdapter.BUY_POST);
            Toast.makeText(BuyItemPreviewActivity.this, temp, Toast.LENGTH_SHORT).show();
        }
    }
}
