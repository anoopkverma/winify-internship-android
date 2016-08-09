package com.example.winify.cvsi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.activities.ItemPreviewActivity;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class ListItemsAdapter extends RecyclerView.Adapter<ListItemsAdapter.ViewHolder> {

    private static final String TAG = "ListItemsAdapter";
    public static String ITEM_POST = "ITEM_POST";

    private final Context context;
    private ListDto<AbstractProductTemplate> allPosts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final CardView cardView;

        public final TextView mTitleTextView;
        public final TextView mDateCreated;
        public final TextView mPrice;
        public final TextView mDescriptionTextView;
        public final ImageView mImageView;


        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            textView = (TextView) v.findViewById(R.id.title_tv);
            mTitleTextView = (TextView) v.findViewById(R.id.title_tv);
            mDescriptionTextView = (TextView) v.findViewById(R.id.description_tv);
            mImageView = (ImageView) v.findViewById(R.id.image_view);

            mDateCreated = (TextView) v.findViewById(R.id.date_text_view);
            mPrice = (TextView) v.findViewById(R.id.price_text_view);
        }
    }


    public ListItemsAdapter(Context context, ListDto<AbstractProductTemplate> allPosts) {
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
        viewHolder.mTitleTextView.setText(allPosts.getList().get(position).getTitle());
        viewHolder.mDateCreated.setText(String.valueOf(allPosts.getList().get(position).getCreatedDate().toString()));
        viewHolder.mPrice.setText(String.valueOf(allPosts.getList().get(position).getPrice()));
//        Picasso.with(context).load(allPosts.getList().get(position).image_url).into(viewHolder.mImageView);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemPreviewActivity.class);
                intent.putExtra(ITEM_POST,allPosts.getList().get(position));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allPosts.getList() != null ? allPosts.getList().size() : 0;
    }
}
