package com.example.winify.cvsi.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.winify.cvsi.fragments.ListItemsFragment;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.HashMap;

/**
 * This class stands as a base class, containing the Navigation Drawer and the Toolbar, with general elements
 */
public class ListItemsActivity extends TestActivity {

    private static ViewGroup viewGroup;
    protected static Fragment fragment;
    private FloatingActionMenu floatingActionMenu;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        showListItemsFragment();
        initToolbar();
        initNavDrawer(R.drawable.nina, savedInstanceState, "diana", "Ileana", this.toolbar);
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);
        initFAMenu();
    }

    public void initToolbar() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create a Borrow product");
        setSupportActionBar(toolbar);
    }


    public void initNavDrawer(int resource, Bundle instance, String name, String email, Toolbar toolbar) {
        this.nabDrawer = new NavigationDrawer(this);
        this.nabDrawer.buildDrawer(this, resource, instance, name, email, toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        nabDrawer.drawer.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (floatingActionMenu.isOpened()) {
            floatingActionMenu.close(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menuu);
        MenuItem menuItem = menuu.findItem(R.id.action_menu);
        getMenuInflater().inflate(R.menu.sub_menu, menuItem.getSubMenu());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(ListItemsActivity.this, "ussy", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initFAMenu() {
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);

        HashMap<FloatingActionButton, Class> fabMapList = new HashMap<FloatingActionButton, Class>();
        fabMapList.put((FloatingActionButton) findViewById(R.id.fab1), CreateBorrowProductActivity.class);
        fabMapList.put((FloatingActionButton) findViewById(R.id.fab2), CreateBuyProductActivity.class);
        fabMapList.put((FloatingActionButton) findViewById(R.id.fab3), CreateSellProductActivity.class);

        for (HashMap.Entry<FloatingActionButton, Class> entry : fabMapList.entrySet()) {
            onMenuButtonClicked(entry.getKey(), entry.getValue());
        }
    }

    private void onMenuButtonClicked(FloatingActionButton fab, final Class classy) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), classy));
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

    public FloatingActionMenu getFloatingActionMenu() {
        return this.floatingActionMenu;
    }
}
