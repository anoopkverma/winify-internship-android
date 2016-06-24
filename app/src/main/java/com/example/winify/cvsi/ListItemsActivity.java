package com.example.winify.cvsi;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    // Added by Cristi
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        Intent activityThatCalled = getIntent();
        initializeToolbar();
        init();
    }

    public void init() {
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new BuyFragment(),"BUY");
        viewPagerAdapter.addFragments(new SellFragment(),"SELL");
        viewPagerAdapter.addFragments(new BorrowFragment(),"BORROW");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void initNavigationDrawer() {
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    checkItemSelected(item);
                    return true;
                }
            });

            onActionBarDrawerToggled(navigationView);
        }

    }

    public void onActionBarDrawerToggled(NavigationView navigationView) {
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        tv_email.setText("raj.amalw@learn2crack.com");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public void checkItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.home:
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash:
                Toast.makeText(getApplicationContext(), "Trash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                finish();
        }
    }

    //TODO - Delete this function

    public void initializeToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
