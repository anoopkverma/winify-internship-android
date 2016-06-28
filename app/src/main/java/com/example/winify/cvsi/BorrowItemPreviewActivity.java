package com.example.winify.cvsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BorrowItemPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_item_preview);

        if (getIntent().hasExtra(BorrowAdapter.BORROW_POST)) {
            String temp = getIntent().getExtras().getString(BorrowAdapter.BORROW_POST);
            Toast.makeText(BorrowItemPreviewActivity.this, temp, Toast.LENGTH_SHORT).show();
        }
    }
}