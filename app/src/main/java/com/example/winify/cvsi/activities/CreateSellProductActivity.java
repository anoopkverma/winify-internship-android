package com.example.winify.cvsi.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.utils.NavigationDrawer;

public class CreateSellProductActivity extends CreateProduct implements View.OnClickListener{

    private Button cancelButton;
    private Button createButton;
    private static int RESULT_LOAD_IMAGE = 1;
    private static final int PERMISSION_REQUEST_CODE = 12;
    private String fPath;
    private View view;
    private Context context;
    private Uri uri;
    private ProductController productController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sell_product);
        initializeComponents();
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);
    }

    public void initializeComponents() {
        productController = new ProductController(getApplicationContext(), new SessionManager(getApplicationContext()).getToken());
        this.context = getApplicationContext();
        this.nabDrawer = new NavigationDrawer(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        this.initToolbar("Create sell product");
        initSpinner();
        initFloatingActionButtonAddImage();
        cancelButton = (Button) findViewById(R.id.cancel_prod_creation_button_sell);
        createButton = (Button) findViewById(R.id.create_product_button_sell);
        cancelButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        view = v;
        int id = v.getId();
        switch (id){
            case R.id.cancel_prod_creation_button_sell:
                if (checkPermission(context)) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, RESULT_LOAD_IMAGE);

                } else {
                    requestPermission(context, PERMISSION_REQUEST_CODE);
                    Snackbar.make(view,"Please request permission.",Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.create_product_button_sell:
                productController.postImage(fPath, uri);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            this.uri = data.getData();
            this.fPath = getFilePath(uri, getContentResolver());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Snackbar.make(view,"Permission Granted, Now you can access location data.",Snackbar.LENGTH_LONG).show();

                } else {

                    Snackbar.make(view,"Permission Denied, You cannot access location data.",Snackbar.LENGTH_LONG).show();

                }
                break;
        }
    }
}
