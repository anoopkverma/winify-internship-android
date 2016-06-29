package com.example.winify.cvsi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.ViewHolder> {

    private static final String TAG = "ListItemsAdapter";
    public static String ITEM_POST = "ITEM_POST";

    private final Context context;
    private List<BuyPost> allPosts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final CardView cardView;

        public final TextView mTitleTextView;
        public final TextView mDescriptionTextView;
        public final ImageView mImageView;


        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            textView = (TextView) v.findViewById(R.id.title_tv);
            mTitleTextView = (TextView) v.findViewById(R.id.title_tv);
            mDescriptionTextView = (TextView) v.findViewById(R.id.description_tv);
            mImageView = (ImageView) v.findViewById(R.id.image_view);
        }
    }


    public ListItemsAdapter(Context context, List<BuyPost> allPosts) {
        this.context = context;
        this.allPosts = allPosts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_item_preview, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListItemsAdapter.ViewHolder viewHolder, final int position) {


        viewHolder.mTitleTextView.setText(allPosts.get(position).title);
        Picasso.with(context).load(allPosts.get(position).image_url).resize(240, 320).into(viewHolder.mImageView);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemPreviewActivity.class);
                intent.putExtra(ITEM_POST,allPosts.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allPosts.size();
    }
}
