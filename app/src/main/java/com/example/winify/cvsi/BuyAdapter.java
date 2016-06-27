package com.example.winify.cvsi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.ViewHolder> {

    private static final String TAG = "BuyAdapter";
    public static String BUY_POST = "BUY_POST";


    private final Context context;

    private String[] mDataSet;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final CardView cardView;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            textView = (TextView) v.findViewById(R.id.title_tv);
        }
    }


    public BuyAdapter(Context context, String[] dataSet) {
        this.context = context;
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.buy_preview, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.textView.setText(mDataSet[position]);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BuyItemPreviewActivity.class);
                intent.putExtra(BUY_POST,mDataSet[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}