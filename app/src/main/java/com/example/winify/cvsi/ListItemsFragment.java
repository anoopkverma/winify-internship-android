package com.example.winify.cvsi;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListItemsFragment extends Fragment {

    private FloatingActionMenu menu;
    protected FloatingActionButton fab_borrow;
    protected FloatingActionButton fab_buy;
    protected FloatingActionButton fab_sell;

    protected RecyclerView mRecyclerView;
    protected ListItemsAdapter mAdapter;
    protected StaggeredGridLayoutManager mLayoutManager;

    private static final int DATASET_COUNT = 30;
    private static int SPAN_COUNT;

    protected List<BuyPost> allPosts;

    public ListItemsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initDataset();
        SPAN_COUNT = getSpanNr();
        final View view =  inflater.inflate(R.layout.fragment_list_items, container, false);
        setmRecyclerViewLayoutManager(view);
        initMenu(view);
        return view;
    }

    public void initMenu(View view) {
        menu = (FloatingActionMenu) view.findViewById(R.id.menu);

        fab_borrow = (FloatingActionButton) view.findViewById(R.id.fab1);
        fab_buy = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab_sell = (FloatingActionButton) view.findViewById(R.id.fab3);

        fab_borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreateBorrowProductActivity.class));
            }
        });

        fab_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreateBuyProductActivity.class));
            }
        });

        fab_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreateSellProductActivity.class));
            }
        });
    }

    public void setmRecyclerViewLayoutManager(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(1);
        mRecyclerView.addItemDecoration(decoration);

        mAdapter = new ListItemsAdapter(getActivity(), allPosts);
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

    private void initDataset() {
        allPosts = new ArrayList<BuyPost>();
        for (int i = 0; i < DATASET_COUNT; i++) {
            BuyPost post = new BuyPost();
            post.setTitle("Dress #" + i + " title");
            post.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, ");
            post.setImage(android_image_urls[i]);
            allPosts.add(post);
        }
    }

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

}
