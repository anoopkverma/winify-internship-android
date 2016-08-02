package com.example.winify.cvsi.activities;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;

public class CreateSellProductActivity extends CreateProduct {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sell_product);
        this.nabDrawer = new NavigationDrawer(this);
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana");
        imageView = (ImageView) findViewById(R.id.image_view);
        this.initToolbar();
        initSpinner();
        initFloatingActionButtonAddImage();
    }
}

