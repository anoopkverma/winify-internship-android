package com.example.winify.cvsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class BuyItemPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_preview);

        if (getIntent().hasExtra(BuyAdapter.BUY_POST)) {
            BuyPost buyPost = (BuyPost)getIntent().getSerializableExtra(BuyAdapter.BUY_POST);

            TextView titleTextView = (TextView) findViewById(R.id.object_title);
            TextView descriptionTextView = (TextView) findViewById(R.id.object_description);

            if (titleTextView != null && descriptionTextView != null ) {
                titleTextView.setText(buyPost.title);
                descriptionTextView.setText(buyPost.description);
            }

            Toast.makeText(BuyItemPreviewActivity.this, buyPost.title, Toast.LENGTH_SHORT).show();
        }
    }
}
