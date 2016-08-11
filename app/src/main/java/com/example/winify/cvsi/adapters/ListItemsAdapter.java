package com.example.winify.cvsi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.activities.ItemPreviewActivity;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.utils.ListDtoFactory;
import com.example.winify.cvsi.utils.PostsViewHolder;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.Subscribe;


/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class ListItemsAdapter extends RecyclerView.Adapter<PostsViewHolder> {

    private static final String TAG = "ListItemsAdapter";
    public static String ITEM_POST = "ITEM_POST";

    private final Context context;
    private List<AbstractProductTemplate> allPosts;

    public ListItemsAdapter(Context context, List<AbstractProductTemplate> _allPosts) {
        this.context = context;
        this.allPosts = new ArrayList<>(_allPosts);
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_item_preview, viewGroup, false);
        return new PostsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder viewHolder, final int position) {
        final AbstractProductTemplate temp = allPosts.get(position);
        viewHolder.bind(temp);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemPreviewActivity.class);
                intent.putExtra(ITEM_POST,temp);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allPosts != null ? allPosts.size() : 0;
    }

    public void animateTo(List<AbstractProductTemplate> posts) {
        applyAndAnimateRemovals(posts);
        applyAndAnimateAdditions(posts);
        applyAndAnimateMovedItems(posts);
    }

    private void applyAndAnimateRemovals(List<AbstractProductTemplate> newPosts) {
        for (int i = allPosts.size() - 1; i >= 0; i--) {
            final AbstractProductTemplate post = allPosts.get(i);
            if (!newPosts.contains(post)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<AbstractProductTemplate> newPosts) {
        for (int i = 0, count = newPosts.size(); i < count; i++) {
            final AbstractProductTemplate post = newPosts.get(i);
            if (!allPosts.contains(post)) {
                addItem(i, post);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<AbstractProductTemplate> newPosts) {
        for (int toPosition = newPosts.size() - 1; toPosition >= 0; toPosition--) {
            final AbstractProductTemplate post = newPosts.get(toPosition);
            final int fromPosition = allPosts.indexOf(post);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public AbstractProductTemplate removeItem(int position) {
        final AbstractProductTemplate post = allPosts.remove(position);
        notifyItemRemoved(position);
        return post;
    }

    public void addItem(int position, AbstractProductTemplate post) {
        allPosts.add(position, post);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final AbstractProductTemplate post = allPosts.remove(fromPosition);
        allPosts.add(toPosition, post);
        notifyItemMoved(fromPosition, toPosition);
    }
}
