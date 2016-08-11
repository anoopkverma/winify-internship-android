package com.example.winify.cvsi.utils;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.activities.ItemPreviewActivity;
import com.example.winify.cvsi.dto.ListDto;

/**
 * Created by diana on 8/10/16.
 */
public class PostsViewHolder extends RecyclerView.ViewHolder{
    public final CardView cardView;
    public final TextView mTitleTextView;
    public final TextView mDateCreated;
    public final TextView mPrice;
    public final TextView mDescriptionTextView;
    public final ImageView mImageView;

    public PostsViewHolder(View v) {
        super(v);
        cardView = (CardView) v.findViewById(R.id.card_view);
        mTitleTextView = (TextView) v.findViewById(R.id.title_tv);
        mDescriptionTextView = (TextView) v.findViewById(R.id.description_tv);
        mImageView = (ImageView) v.findViewById(R.id.image_view);

        mDateCreated = (TextView) v.findViewById(R.id.date_text_view);
        mPrice = (TextView) v.findViewById(R.id.price_text_view);
    }

    public void bind(AbstractProductTemplate temp) {
        mTitleTextView.setText(temp.getTitle());
        mDateCreated.setText(temp.getCreatedDate().toString());
        mPrice.setText(String.valueOf(temp.getPrice()));
//        Picasso.with(context).load(allPosts.getList().get(position).image_url).into(viewHolder.mImageView);
    }
}