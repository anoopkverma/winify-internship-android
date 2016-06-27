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
 * Created by diana on 6/26/16.
 */
public class SellAdapter extends RecyclerView.Adapter<SellAdapter.ViewHolder> {

    private String[] mDataSet;
    public static String SELL_POST = "SELL_POST";
    private final Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final CardView cardView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.title_tv);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }


    public SellAdapter(Context context, String[] dataSet) {
        this.context = context;
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sell_preview, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.textView.setText(mDataSet[position]);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SellItemPreviewActivity.class);
                intent.putExtra(SELL_POST, mDataSet[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}