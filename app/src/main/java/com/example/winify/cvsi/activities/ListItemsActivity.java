package com.example.winify.cvsi.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.winify.cvsi.SpacesItemDecoration;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.utils.ListDtoFactory;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.HashMap;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * This class stands as a base class, containing the Navigation Drawer and the Toolbar, with general elements
 */
public class ListItemsActivity extends TestActivity {

    private static ViewGroup viewGroup;
    protected static Fragment fragment;
    private FloatingActionMenu floatingActionMenu;
    private Toolbar toolbar;
    protected ListDto<AbstractProductTemplate> allPosts;
    private ProductController productController;
    private View view;
    protected RecyclerView mRecyclerView;
    protected StaggeredGridLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        view = this.findViewById(android.R.id.content).getRootView();

//        showListItemsFragment();
        initToolbar();
        initNavDrawer(R.drawable.nina, savedInstanceState, "diana", "Ileana", this.toolbar);
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);
        initFAMenu();

        EventBus.getDefault().register(this);
        productController = new ProductController();
        productController.getProductDTO();
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

    private int getSpanNr() {
        int tempSpan = 2;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tempSpan = 3;
        } else {
            tempSpan = 2;
        }
        if (getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            tempSpan++;
        }
        return tempSpan;
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
                Log.i("tearch", "tearch");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<AbstractProductTemplate> event) {

        this.allPosts = ListDtoFactory.getProduct(event);

        Toast.makeText(ListItemsActivity.this, allPosts.getList().get(0).getTitle() + "shit", Toast.LENGTH_SHORT).show();
        setmRecyclerViewLayoutManager(view);
    }

    public void setmRecyclerViewLayoutManager(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        Log.i("Banana", "o mers");
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(getSpanNr(), StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(1));

        mRecyclerView.setAdapter(new ListItemsAdapter(getApplicationContext(), allPosts));

        mLayoutManager = new StaggeredGridLayoutManager(getSpanNr(), StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        int scrollPosition = 0;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0) {
                    floatingActionMenu.hideMenuButton(true);
                }
                else if (dy < 0)
                    floatingActionMenu.showMenuButton(true);
            }
        });
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


}
