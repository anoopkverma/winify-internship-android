package com.example.winify.cvsi.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.ViewGroup;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.fragments.ViewBorrowProductDetailsFragment;
import com.example.winify.cvsi.utils.NavigationDrawer;


public class ItemPreviewActivity extends ToolbarActivity {

    private ViewGroup viewGroup;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);
        this.nabDrawer = new NavigationDrawer(this);
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);
        initToolbar(" ");
        showProductDetailsFragment();
    }

    public void showProductDetailsFragment() {
        viewGroup = (ViewGroup) findViewById(R.id.fragment_place);
        fragment = new ViewBorrowProductDetailsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fragment);
        fragmentTransaction.commit();
    }
}
