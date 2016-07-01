package com.example.winify.cvsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CreateBorrowProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_borrow_product);

        initToolbar();
//        initButtons();

        Intent getCallingActivity = getIntent();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create a Borrow product");
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    public void initButtons() {
//        final Button createButton = (Button) findViewById(R.id.create_product_button);
//        if (createButton != null) {
//            createButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    createButton.setBackground(getResources().getDrawable(R.drawable.selector));
//                }
//            });
//        }
//    }
}
