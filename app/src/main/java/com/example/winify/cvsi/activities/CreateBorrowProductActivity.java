package com.example.winify.cvsi.activities;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;

public class CreateBorrowProductActivity extends CreateProduct {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_borrow_product);
        imageView = (ImageView) findViewById(R.id.image_view);
        this.nabDrawer = new NavigationDrawer(this);
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);
//        this.setDrawerSelection(1);

        initSpinner();
        initFloatingActionButtonAddImage();
    }

}
