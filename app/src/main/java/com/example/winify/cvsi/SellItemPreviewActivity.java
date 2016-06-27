package com.example.winify.cvsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SellItemPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_item_preview);

        if (getIntent().hasExtra(SellAdapter.SELL_POST)) {
            String temp = getIntent().getExtras().getString(SellAdapter.SELL_POST);
            Toast.makeText(SellItemPreviewActivity.this, temp, Toast.LENGTH_SHORT).show();
        }
    }
}
