package com.example.winify.cvsi.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.winify.cvsi.BuyPost;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.example.winify.cvsi.R;
import com.squareup.picasso.Picasso;


public class ItemPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);
        initToolbar();

        if (getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            BuyPost buyPost = (BuyPost)getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            TextView titleTextView = (TextView) findViewById(R.id.title_tv);
            TextView descriptionTextView = (TextView) findViewById(R.id.description_tv);
            ImageView imageView = (ImageView) findViewById(R.id.image_view);

            if (titleTextView != null && descriptionTextView != null ) {
                titleTextView.setText(buyPost.title);
                descriptionTextView.setText(buyPost.description);

                Picasso.with(this).load(buyPost.image_url).into(imageView);
            }
        }
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}