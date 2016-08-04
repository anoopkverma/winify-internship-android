package com.example.winify.cvsi.fragments;


import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.activities.ListItemsActivity;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.SpacesItemDecoration;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.utils.ListDtoFactory;
import com.github.clans.fab.FloatingActionMenu;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListItemsFragment extends Fragment {

    private FloatingActionMenu menu;


    protected RecyclerView mRecyclerView;
    protected ListItemsAdapter mAdapter;
    protected StaggeredGridLayoutManager mLayoutManager;

    private static final int DATASET_COUNT = 2;
    private static int SPAN_COUNT;

    protected ListDto<AbstractProductTemplate> allPosts;

    ListDtoFactory factory;

    protected ListDto<ProductTemplate> listDtoObject;
    private ProductController productController;

    private View view;
    public ListItemsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SPAN_COUNT = getSpanNr();
        this.view =  inflater.inflate(R.layout.fragment_list_items, container, false);

        this.menu = ((ListItemsActivity)this.getActivity()).getMenu();
//        menu = (FloatingActionMenu) this.view.findViewById(R.id.menu);

        EventBus.getDefault().register(this);
        productController = new ProductController();
        productController.getProductDTO();


//        setmRecyclerViewLayoutManager(view);
        return view;
    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<AbstractProductTemplate> event) {

        this.allPosts = ListDtoFactory.getProduct(event);

        Toast.makeText(getActivity(), allPosts.getList().get(0).getTitle() + "shit", Toast.LENGTH_SHORT).show();
//        for (int i = 0; i < event.getList().size(); i++) {
//            allPosts.getList().get(i).setTitle(event.getList().get(i).getTitle());
//            allPosts.getList().get(i).setDescription(event.getList().get(i).getDescription());
////            allPosts.getList().get(i).setCreatedDate((Date)event.getList().get(i).getCreatedDate());
//            allPosts.getList().get(i).setPrice(event.getList().get(i).getPrice());
//            allPosts.getList().get(i).setBorrow(event.getList().get(i).getBorrow());
//            allPosts.getList().get(i).setCategoryEnumList(event.getList().get(i).getCategoryEnumList());
//            allPosts.getList().get(i).setCurrency(event.getList().get(i).getCurrency());
//            allPosts.getList().get(i).setLimitDate(event.getList().get(i).getLimitDate());
//            allPosts.getList().get(i).setUserName(event.getList().get(i).getUserName());
//        }
        setmRecyclerViewLayoutManager(view);
    }

    public void setmRecyclerViewLayoutManager(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        Log.i("Banana", "o mers");
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(1);
        mRecyclerView.addItemDecoration(decoration);

        mAdapter = new ListItemsAdapter(getActivity(), allPosts);
        mRecyclerView.setAdapter(mAdapter);

        mLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        int scrollPosition = 0;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0) {
                    menu.hideMenuButton(true);
                }
                else if (dy < 0)
                    menu.showMenuButton(true);
            }
        });
    }



    public void checkMenuExpanded(View layout, final FloatingActionMenu menu) {
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (menu.isOpened()) {
                    menu.hideMenu(true);
                }
                return true;
            }
        });
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
}

