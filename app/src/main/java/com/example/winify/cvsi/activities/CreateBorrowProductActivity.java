package com.example.winify.cvsi.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.dto.templates.request.ProductCreateClientRequest;
import com.example.winify.cvsi.fragments.CalendarFragment;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;

public class CreateBorrowProductActivity extends CreateProduct implements View.OnClickListener{

    private RadioGroup radioGroup;
    private RadioButton rbBorrow;
    private RadioButton rbLend;
    private Button create_borrow_prod_btn;
    private static Fragment fragment;
    private LinearLayout scrollView;
    private ProductController productController;
    private SessionManager sessionManager;
    private static final int PERMISSION_REQUEST_CODE = 100;
    private FloatingActionButton addImageFAB;
    private View view;
    private static int RESULT_LOAD_IMAGE = 1;
    private String fPath;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_borrow_product);
        initializeData();
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState,
                this.toolbar);
    }

    public void initializeData() {
        addImageFAB = (FloatingActionButton) findViewById(R.id.fab_add_image_borrow);
        addImageFAB.setOnClickListener(this);
        this.initToolbar("Create a borrow product");
        imageView = (ImageView) findViewById(R.id.image_view);
        this.nabDrawer = new NavigationDrawer(this);
        scrollView = (LinearLayout) findViewById(R.id.scroll_view) ;
        initSpinner();
        fragment = new CalendarFragment();
        initRadioGroup(this.findViewById(android.R.id.content));
    }

    public void initRadioGroup(final View view){
        radioGroup = (RadioGroup) view.findViewById(R.id.radioButtonGroup);
        rbBorrow = (RadioButton) view.findViewById(R.id.borrow_radio_button);
        rbLend = (RadioButton) view.findViewById(R.id.lend_radio_button);
        create_borrow_prod_btn = (Button) view.findViewById(R.id.create_borrow_product_button);
        productController = new ProductController(this.getApplicationContext());
        create_borrow_prod_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productController.createProduct(new ProductCreateClientRequest());
            }
        });
        onRbClick(rbBorrow);
        onRbClick(rbLend);
    }

    public void onRbClick(final View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);;
                scrollView.setVisibility(View.VISIBLE);
                ft.commit();
            }
        });
    }

    @Override
    public void onClick(View v) {
        view = v;
        int id = v.getId();
        switch (id){
            case R.id.fab_add_image_borrow:
                if (checkPermission(getApplicationContext())) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, RESULT_LOAD_IMAGE);

                } else {
                    requestPermission(getApplicationContext(), PERMISSION_REQUEST_CODE);
                    Snackbar.make(view,"Please request permission.",Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.create_product_button_buy:
                if (fPath != null && uri != null) {
                    productController.postImage(fPath, uri);
                } else {
                    Snackbar.make(view,"Please select an image, then create the product..",Snackbar.LENGTH_LONG).show();
                }
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
