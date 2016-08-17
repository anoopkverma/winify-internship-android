package com.example.winify.cvsi.activities;

import android.accounts.AbstractAccountAuthenticator;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.winify.cvsi.SpacesItemDecoration;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.utils.ListDtoFactory;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Filter;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * This class stands as a base class, containing the Navigation Drawer and the Toolbar, with general elements
 */
public class ListItemsActivity extends TestActivity implements SearchView.OnQueryTextListener {

    private static ViewGroup viewGroup;
    private FloatingActionMenu floatingActionMenu;
    private Toolbar toolbar;
    protected ListDto<AbstractProductTemplate> allPosts;
    private ProductController productController;
    private View view;
    protected RecyclerView mRecyclerView;
    private ListItemsAdapter mAdaper;
    protected StaggeredGridLayoutManager mLayoutManager;
    private SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        view = this.findViewById(android.R.id.content).getRootView();
        initToolbar();
        initNavDrawer(R.drawable.nina, savedInstanceState, "diana", "Ileana", this.toolbar);
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.menu);
        initFAMenu();
        EventBus.getDefault().register(this);
        productController = new ProductController(this.getApplicationContext(), new SessionManager(getApplicationContext()).getToken());
        productController.getProductDTO();
    }

    public void initToolbar() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_items_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search_field);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        menuItem = menu.findItem(R.id.action_menu);
        getMenuInflater().inflate(R.menu.sub_menu, menuItem.getSubMenu());
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_buy:
                onFilteredByCategory("BUY");
                return true;
            case R.id.action_sell:
                onFilteredByCategory("SELL");
                return true;
            case R.id.action_borrow:
                onFilteredByCategory("BORROW");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<AbstractProductTemplate> event) {
        this.allPosts = ListDtoFactory.getProduct(event);
        setmRecyclerViewLayoutManager(view);
    }

    public void setmRecyclerViewLayoutManager(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(getSpanNr(), StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(1));
        mAdaper = new ListItemsAdapter(getApplicationContext(), allPosts.getList());
        mRecyclerView.setAdapter(mAdaper);
        mLayoutManager = new StaggeredGridLayoutManager(getSpanNr(), StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(0);
        onRecyclerScrolled();
    }

    public void onRecyclerScrolled() {
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

    @Override
    public boolean onQueryTextChange(String query) {
        final List<AbstractProductTemplate> filteredModelList = filter(allPosts.getList(), query);
        mAdaper.animateTo(filteredModelList);
        mRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    private List<AbstractProductTemplate> filter(List<AbstractProductTemplate> posts, String query) {
        query = query.toLowerCase();

        final List<AbstractProductTemplate> filteredModelList = new ArrayList<>();
        for (AbstractProductTemplate post : posts) {
            final String text = post.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(post);
            }
        }
        return filteredModelList;
    }

    public void onFilteredByCategory(String query) {
        final List<AbstractProductTemplate> filteredModelList = filterByCategory(allPosts.getList(), query);
        mAdaper.animateTo(filteredModelList);
        mRecyclerView.scrollToPosition(0);
    }

    public List<AbstractProductTemplate> filterByCategory(List<AbstractProductTemplate> posts, String query) {
        query = query.toLowerCase();

        final List<AbstractProductTemplate> filteredModelList = new ArrayList<>();
        for (AbstractProductTemplate post : posts) {
            final List<String> text = new ArrayList<>();
            for (int i = 0; i < post.getCategories().size(); i++) {
                text.add(String.valueOf(post.getCategories().toArray()[i]).toLowerCase());

                if (text.get(i).contains(query)) {
                    filteredModelList.add(post);
                }
            }
        }
        return filteredModelList;
    }
}
