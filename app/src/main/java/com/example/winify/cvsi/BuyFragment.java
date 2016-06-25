package com.example.winify.cvsi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected LinearLayoutManager mLinearLayoutManager;
    protected List<BuyPost> mDataset;
    protected BuyListAdapter mBuyListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    public BuyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */

        View view = inflater.inflate(R.layout.fragment_buy, container, false);

        mBuyListAdapter = new BuyListAdapter(mDataset);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.cardList);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        return view;
    }

    public void initData() {
        mDataset = new ArrayList<BuyPost>();
        for (int i = 0; i < 2; i++) {
            mDataset.add(new BuyPost());
            mDataset.get(i).setTitle("New title");
            mDataset.get(i).setDescription("New descrition");
            mDataset.get(i).setPrice((float) 12.00);
        }
    }
}
