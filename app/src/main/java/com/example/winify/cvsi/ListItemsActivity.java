package com.example.winify.cvsi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

public class ListItemsActivity extends AppCompatActivity {

    private final String android_image_urls[] = {
            "http://cdn.terranovastyle.com/media/catalog/product/S/A/SAB0020832001S189_list.jpg",
            "https://floridesalcam.files.wordpress.com/2012/06/forever-21-floral-skater-dress-with-belt.jpg",
            "http://picture-cdn.wheretoget.it/pw7o89-i.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/36/5e/16/365e16f3d5970b8829ea777702bbe704.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/41/29/f6/4129f6cba00ebf8210714d5dfed9f1f2.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=66718352",
            "http://slimages.macys.com/is/image/MCY/products/2/optimized/2099762_fpx.tif?op_sharpen=1",
            "http://cdn.terranovastyle.com/media/catalog/product/S/A/SAB0020821001S120_det_3.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=64821014",
            "http://kingofwallpapers.com/landscape/landscape-007.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/f9/00/9f/f9009f49df2bd9d76c4693185501bc12.jpg",
            "http://cdn.terranovastyle.com/media/catalog/product/S/A/SAB0020832001S189_list.jpg",
            "https://floridesalcam.files.wordpress.com/2012/06/forever-21-floral-skater-dress-with-belt.jpg",
            "http://picture-cdn.wheretoget.it/pw7o89-i.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/36/5e/16/365e16f3d5970b8829ea777702bbe704.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/41/29/f6/4129f6cba00ebf8210714d5dfed9f1f2.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=66718352",
            "http://slimages.macys.com/is/image/MCY/products/2/optimized/2099762_fpx.tif?op_sharpen=1",
            "http://cdn.terranovastyle.com/media/catalog/product/S/A/SAB0020821001S120_det_3.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=64821014",
            "http://kingofwallpapers.com/landscape/landscape-007.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/f9/00/9f/f9009f49df2bd9d76c4693185501bc12.jpg",
            "http://cdn.terranovastyle.com/media/catalog/product/S/A/SAB0020832001S189_list.jpg",
            "https://floridesalcam.files.wordpress.com/2012/06/forever-21-floral-skater-dress-with-belt.jpg",
            "http://picture-cdn.wheretoget.it/pw7o89-i.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/36/5e/16/365e16f3d5970b8829ea777702bbe704.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/41/29/f6/4129f6cba00ebf8210714d5dfed9f1f2.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=66718352",
            "http://slimages.macys.com/is/image/MCY/products/2/optimized/2099762_fpx.tif?op_sharpen=1",
            "http://cdn.terranovastyle.com/media/catalog/product/S/A/SAB0020821001S120_det_3.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=64821014",
            "http://kingofwallpapers.com/landscape/landscape-007.jpg",
            "https://s-media-cache-ak0.pinimg.com/236x/f9/00/9f/f9009f49df2bd9d76c4693185501bc12.jpg"
    };

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    protected String TAG = "ListItemsActivity";
    private static final int DATASET_COUNT = 30;
    private static int SPAN_COUNT;

    protected RecyclerView mRecyclerView;
    protected ListItemsAdapter mAdapter;
    protected StaggeredGridLayoutManager mLayoutManager;


    private FloatingActionMenu menu;
    protected FloatingActionButton fab_borrow;
    protected FloatingActionButton fab_buy;
    protected FloatingActionButton fab_sell;


    protected List<BuyPost> allPosts;

    // Data for the Drawer
    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private FloatingActionButton programFab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            SPAN_COUNT = 3;
        } else {
            SPAN_COUNT = 2;
        }
        if (getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE)) {
            SPAN_COUNT++;
        }

        initDataset();
        setmRecyclerViewLayoutManager();
        initNavigationDrawer();
        checkDrawerEvent();
        initToolbar();
        initMenu();
        Intent activityThatCalled = getIntent();
    }

    public void initMenu() {
        menu = (FloatingActionMenu) findViewById(R.id.menu);

        fab_borrow = (FloatingActionButton) findViewById(R.id.fab1);
        fab_buy = (FloatingActionButton) findViewById(R.id.fab2);
        fab_sell = (FloatingActionButton) findViewById(R.id.fab3);

        fab_borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateBorrowProductActivity.class));
            }
        });

        fab_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateBuyProductActivity.class));
            }
        });

        fab_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateSellProductActivity.class));
            }
        });
    }

    public void checkMenuExpanded(View layout, final FloatingActionMenu menu) {
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(menu.isOpened()) {
                    menu.hideMenu(true);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (mDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
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

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public void initNavigationDrawer() {

        addItemsToNavList();
        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // populate NavigationDrawer vith options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter mDrawerListAdapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(mDrawerListAdapter);

        // Drawer Item Click listerners
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });
    }

    public void selectItemFromDrawer(int position) {
        Fragment fragment = new PreferencesFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainContent, fragment)
                .commit();
        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    public void setmRecyclerViewLayoutManager() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(1);
        mRecyclerView.addItemDecoration(decoration);

        mAdapter = new ListItemsAdapter(this, allPosts);
        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        int scrollPosition = 0;

//        if (mRecyclerView.getLayoutManager() != null) {
//            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
//                    .findFirstCompletelyVisibleItemPosition();
//        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    public void checkDrawerEvent() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d(TAG, "onDrawerClosed: " + getTitle());

                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addItemsToNavList() {
        mNavItems.add(new NavItem("Home", "Meetup Destination", R.drawable.ic_home_white_24dp));
        mNavItems.add(new NavItem("Settings", "Change your preferences", R.drawable.ic_settings_white_24dp));
        mNavItems.add(new NavItem("About", "Learn more about us", R.drawable.ic_info_outline_white_24dp));
    }

    private void initDataset() {
        allPosts = new ArrayList<BuyPost>();
        for (int i = 0; i < DATASET_COUNT; i++) {
            BuyPost post = new BuyPost();
            post.setTitle("Dress #" + i);
            post.setDescription("some description to be inserted here.");
            post.setImage(android_image_urls[i]);
            allPosts.add(post);
        }
    }

}
