package com.example.winify.cvsi.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.fragments.ViewBorrowProductDetailsFragment;
import com.example.winify.cvsi.fragments.ViewSellBuyProductDetailsFragment;


public class ItemPreviewActivity extends BaseActivity {

    private ViewGroup viewGroup;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);
        this.initBuilder();
        initToolbar();

        showBorrowProductDetailsFragment();
    }

    public void showBuySellProductDetailsFragment() {
        viewGroup = (ViewGroup) findViewById(R.id.fragment_place);
        fragment = new ViewSellBuyProductDetailsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }

    public void showBorrowProductDetailsFragment() {
        viewGroup = (ViewGroup) findViewById(R.id.fragment_place);
        fragment = new ViewBorrowProductDetailsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }


    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}