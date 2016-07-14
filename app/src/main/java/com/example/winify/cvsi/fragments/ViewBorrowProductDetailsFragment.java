package com.example.winify.cvsi.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.winify.cvsi.BuyPost;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewBorrowProductDetailsFragment extends Fragment {


    public ViewBorrowProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view_borrow_product_details, container, false);
        getTheExtra(view);
        return view;
    }

    public void getTheExtra(View view) {
        if (getActivity().getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            BuyPost buyPost = (BuyPost)getActivity().getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            TextView titleTextView = (TextView) view.findViewById(R.id.title_tv);
            TextView descriptionTextView = (TextView) view.findViewById(R.id.description_tv);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
            TextView startDateTV = (TextView) view.findViewById(R.id.starting_date);
            TextView endDateTV = (TextView) view.findViewById(R.id.end_date);
            TextView priceTV = (TextView) view.findViewById(R.id.price_tv);
            Button currentyTypeButton = (Button) view.findViewById(R.id.currency_button);
            Button borrowTypeButton = (Button) view.findViewById(R.id.button_type);


            if (titleTextView != null && descriptionTextView != null && priceTV != null) {
                titleTextView.setText(buyPost.getTitle());
                priceTV.setText(String.valueOf(buyPost.getPrice()));
                currentyTypeButton.setText(buyPost.getCurrency().toString());
                descriptionTextView.setText(buyPost.getDescription());
//                borrowTypeButton.setText(buyPost.getBorrow().toString());

                Picasso.with(getActivity()).load(buyPost.image_url).into(imageView);
            }
        }
    }
}
