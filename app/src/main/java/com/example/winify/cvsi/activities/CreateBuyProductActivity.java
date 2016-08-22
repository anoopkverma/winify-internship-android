package com.example.winify.cvsi.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;

public class CreateBuyProductActivity extends CreateProduct {

    private Button cancelButton;
    private Button createButton;
    private static int RESULT_LOAD_IMAGE = 1;
    private View view;
    private ProductController productController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_buy_product);
        intial();
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);

    }

    public void intial() {
        productController = new ProductController(getApplicationContext(), new SessionManager(getApplicationContext()).getToken());
        this.nabDrawer = new NavigationDrawer(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        this.initToolbar("Create sell product");
        initSpinner();
        initFloatingActionButtonAddImage();
        cancelButton = (Button) findViewById(R.id.cancel_prod_creation_button_buy);
        createButton = (Button) findViewById(R.id.create_product_button_buy);
    }

//    @Override
//    public void onClick(View v) {
//        view = v;
//        int id = v.getId();
//        switch (id){
//            case R.id.cancel_prod_creation_button_sell:
//                if (checkPermission()) {
//                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(i, RESULT_LOAD_IMAGE);
//
//                } else {
//                    requestPermission();
//                    Snackbar.make(view,"Please request permission.",Snackbar.LENGTH_LONG).show();
//                }
//                break;
//            case R.id.create_product_button_sell:
//                productController.postImage(this.getfPath(), this.getUri());
//                break;
//        }
//    }


}
