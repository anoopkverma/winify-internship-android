package com.example.winify.cvsi;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListItemsActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;


    /*********************************/
    private static final int DATASET_COUNT = 60;
    protected RecyclerView mRecyclerView;
    protected ListItemsAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;

    protected List<BuyPost> allPosts;
    /***********************************/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        initDataset();


        /***********************************/
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new ListItemsAdapter(this, allPosts);
        mRecyclerView.setAdapter(mAdapter);

        setmRecyclerViewLayoutManager();
        /******************************/



        Intent activityThatCalled = getIntent();
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



    /**********************************/
    public void setmRecyclerViewLayoutManager() {
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        int scrollPosition = 0;

        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    private void initDataset() {
        allPosts = new ArrayList<BuyPost>();
        for (int i = 0; i < DATASET_COUNT; i++) {
            BuyPost post = new BuyPost();
            post.setTitle("This is element obj #" + i);
            post.setDescription("some description to be inserted here.");
            allPosts.add(post);
        }
    }
}
