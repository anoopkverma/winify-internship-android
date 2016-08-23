package com.example.winify.cvsi.activities;

import android.content.Context;
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

public class CreateBuyProductActivity extends CreateProduct implements View.OnClickListener{

    private Button cancelButton;
    private Button createButton;
    private static int RESULT_LOAD_IMAGE = 1;
    private View view;
    private ProductController productController;
    private Context context;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private String fPath;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_buy_product);
        intial();
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);

    }

    public void intial() {
        this.context = getApplicationContext();
        productController = new ProductController(getApplicationContext(), new SessionManager(getApplicationContext()).getToken());
        this.nabDrawer = new NavigationDrawer(this);
        imageView = (ImageView) findViewById(R.id.image_view);
        this.initToolbar("Create sell product");
        initSpinner();
        initFloatingActionButtonAddImage();
        cancelButton = (Button) findViewById(R.id.cancel_prod_creation_button_buy);
        createButton = (Button) findViewById(R.id.create_product_button_buy);
        cancelButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        view = v;
        int id = v.getId();
        switch (id){
            case R.id.cancel_prod_creation_button_buy:
                if (checkPermission(context)) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, RESULT_LOAD_IMAGE);

                } else {
                    requestPermission(context, PERMISSION_REQUEST_CODE);
                    Snackbar.make(view,"Please request permission.",Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.create_product_button_buy:
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
