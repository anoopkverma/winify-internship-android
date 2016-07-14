package com.example.winify.cvsi.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.winify.cvsi.fragments.ListItemsFragment;
import com.example.winify.cvsi.NavItem;
import com.example.winify.cvsi.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

/**
 * This class stands as a base class, containing the Navigation Drawer and the Toolbar, with general elements
 */
public class ListItemsActivity extends BaseActivity {

    private static ViewGroup viewGroup;
    protected static Fragment fragment;
    private FloatingActionMenu menu;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.initBuilder();
        menu = (FloatingActionMenu) findViewById(R.id.menu);
        showListItemsFragment();
        initMenu();
        initToolbar();


    }

    @Override
    public void onBackPressed() {
        if (menu.isOpened()) {
            menu.close(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_menu);
        getMenuInflater().inflate(R.menu.sub_menu, menuItem.getSubMenu());
        return true;
    }

    public void initMenu() {
        menu = (FloatingActionMenu) findViewById(R.id.menu);
        FloatingActionButton fab_borrow = (FloatingActionButton) findViewById(R.id.fab1);
        FloatingActionButton fab_buy = (FloatingActionButton) findViewById(R.id.fab2);
        FloatingActionButton fab_sell = (FloatingActionButton) findViewById(R.id.fab3);

        fab_borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.isOpened()) {
                    menu.close(true);
                }
                startActivity(new Intent(getBaseContext(), CreateBorrowProductActivity.class));
            }
        });

        fab_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.isOpened()) {
                    menu.close(true);
                }
                startActivity(new Intent(getBaseContext(), CreateBuyProductActivity.class));
            }
        });

        fab_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.isOpened()) {
                    menu.close(true);
                }
                startActivity(new Intent(getBaseContext(), CreateSellProductActivity.class));
            }
        });
    }

    public void showListItemsFragment() {
        viewGroup = (ViewGroup) findViewById(R.id.fragment_place);
        fragment = new ListItemsFragment();
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
