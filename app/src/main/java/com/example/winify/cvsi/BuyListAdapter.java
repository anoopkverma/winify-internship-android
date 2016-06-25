package com.example.winify.cvsi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by diana on 6/25/16.
 */
public class BuyListAdapter extends RecyclerView.Adapter<BuyListAdapter.BuyViewHolder> {

    private List<BuyPost>  _buyPostList;

    public BuyListAdapter (List<BuyPost> buyPostList) {
        this._buyPostList = buyPostList;
    }

    @Override
    public void onBindViewHolder(BuyViewHolder buyViewHolder, int i) {
        BuyPost buyPost = _buyPostList.get(i);
        buyViewHolder.vTilte.setText(buyPost.title);
        buyViewHolder.vDescription.setText(buyPost.description);
        buyViewHolder.vPrice.setText(Float.toString(buyPost.price));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public BuyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.buy_preview, viewGroup, false);

        return new BuyViewHolder(itemView);
    }


    public class BuyViewHolder extends RecyclerView.ViewHolder {
        protected TextView vTilte;
        protected TextView vDescription;
        protected TextView vPrice;

        public BuyViewHolder(View v) {
            super(v);
            vTilte = (TextView) v.findViewById(R.id.title_tv);
            vDescription = (TextView) v.findViewById(R.id.description_tv);
            vPrice = (TextView)v.findViewById(R.id.price_tv);
        }
    }
}
