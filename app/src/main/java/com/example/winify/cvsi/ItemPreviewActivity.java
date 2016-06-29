package com.example.winify.cvsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ItemPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        if (getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            BuyPost buyPost = (BuyPost)getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            TextView titleTextView = (TextView) findViewById(R.id.title_tv);
            TextView descriptionTextView = (TextView) findViewById(R.id.description_tv);

            if (titleTextView != null && descriptionTextView != null ) {
                titleTextView.setText(buyPost.title);
                descriptionTextView.setText(buyPost.description);
            }

            Toast.makeText(ItemPreviewActivity.this, buyPost.title, Toast.LENGTH_SHORT).show();
        }
    }
}