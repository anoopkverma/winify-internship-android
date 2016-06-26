package com.example.winify.cvsi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SellFragment extends Fragment {

    private static final int DATASET_COUNT = 20;

    protected RecyclerView mRecyclerView;
    protected SellAdapter mSellAdapter;
    protected LinearLayoutManager mLayoutManager;
    protected String[] mDataSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }

    public SellFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sell, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        mSellAdapter = new SellAdapter(mDataSet);
        mRecyclerView.setAdapter(mSellAdapter);

        setmRecyclerViewLayoutManager();

        return v;
    }

    public void setmRecyclerViewLayoutManager() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        int scrollPosition = 0;

        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    };

    private void initDataset() {
        mDataSet = new  String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataSet[i] = "Sell element #" + i;
        }
    }
}

