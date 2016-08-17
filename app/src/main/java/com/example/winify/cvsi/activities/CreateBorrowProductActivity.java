package com.example.winify.cvsi.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

public class CreateBorrowProductActivity extends CreateProduct {

    private RadioGroup radioGroup;
    private RadioButton rbBorrow;
    private RadioButton rbLend;
    private Button create_borrow_prod_btn;
    private static Fragment fragment;
    private LinearLayout scrollView;
    private ProductController productController;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_borrow_product);
        this.initToolbar("Create a borrow product");
        imageView = (ImageView) findViewById(R.id.image_view);
        this.nabDrawer = new NavigationDrawer(this);
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);
//        this.setDrawerSelection(1);
        scrollView = (LinearLayout) findViewById(R.id.scroll_view) ;
        initSpinner();
        initFloatingActionButtonAddImage();
        fragment = new CalendarFragment();
        initRadioGroup(this.findViewById(android.R.id.content));
    }


    public void initRadioGroup(final View view){
        radioGroup = (RadioGroup) view.findViewById(R.id.radioButtonGroup);
        rbBorrow = (RadioButton) view.findViewById(R.id.borrow_radio_button);
        rbLend = (RadioButton) view.findViewById(R.id.lend_radio_button);
        create_borrow_prod_btn = (Button) view.findViewById(R.id.create_borrow_product_button);
        productController = new ProductController(this.getApplicationContext(), new SessionManager(getApplicationContext()).getToken());
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
}
