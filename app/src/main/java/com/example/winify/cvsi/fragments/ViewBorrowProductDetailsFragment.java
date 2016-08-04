package com.example.winify.cvsi.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.example.winify.cvsi.dto.templates.ProductTemplate;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewBorrowProductDetailsFragment extends Fragment {

    AbstractProductTemplate prod;
    TextView titleTextView;
    TextView descriptionTextView;
    ImageView imageView;
    TextView startDateTV;
    TextView endDateTV;
    TextView priceTV;
    Button currentyTypeButton;
    Button borrowTypeButton;



    public ViewBorrowProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_view_sell_buy_product, container, false);

        if (getActivity().getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            prod = (AbstractProductTemplate) getActivity().getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            if (prod != null ) {
                if (prod.getBorrow()) {
                    view = inflater.inflate(R.layout.fragment_view_borrow_product_details, container, false);
                    getTheExtra(view);
                }
            }
        }

        getTheExtra(view);
        return view;
    }

//    public void initUI(View view) {
//        this.titleTextView = (TextView) view.findViewById(R.id.title_tv);
//        this.descriptionTextView = (TextView) view.findViewById(R.id.description_tv);
//        this.imageView = (ImageView) view.findViewById(R.id.image_view);
//        this.startDateTV = (TextView) view.findViewById(R.id.starting_date);
//        this.endDateTV = (TextView) view.findViewById(R.id.end_date);
//        this.priceTV = (TextView) view.findViewById(R.id.price_tv);
//        this.currentyTypeButton = (Button) view.findViewById(R.id.currency_button);
//        this.borrowTypeButton = (Button) view.findViewById(R.id.button_type);
//    }
//
//    public void getTheExtra(View view) {
//        initUI(view);
//        if (titleTextView != null && descriptionTextView != null && priceTV != null && buyPost != null) {
//            titleTextView.setText(buyPost.getTitle());
//            priceTV.setText(String.valueOf(buyPost.getPrice()));
//            currentyTypeButton.setText(buyPost.getCurrency().toString());
//            descriptionTextView.setText(buyPost.getDescription());
////                borrowTypeButton.setText(buyPost.getBorrow().toString());
//            Picasso.with(getActivity()).load(buyPost.image_url).into(imageView);
//        }
//    }

    public void getTheExtra(View view) {
        if (getActivity().getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            prod = (AbstractProductTemplate) getActivity().getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            TextView titleTextView = (TextView) view.findViewById(R.id.title_tv);
            TextView descriptionTextView = (TextView) view.findViewById(R.id.description_tv);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
            TextView startDateTV = (TextView) view.findViewById(R.id.starting_date);
            TextView endDateTV = (TextView) view.findViewById(R.id.end_date);
            TextView priceTV = (TextView) view.findViewById(R.id.price_tv);
            Button currentyTypeButton = (Button) view.findViewById(R.id.currency_button);
            Button borrowTypeButton = (Button) view.findViewById(R.id.button_type);
            if (titleTextView != null && descriptionTextView != null && priceTV != null) {
                titleTextView.setText(prod.getTitle());
                priceTV.setText(String.valueOf(prod.getPrice()));
//                currentyTypeButton.setText(buyPost.getCurrency().toString());
                descriptionTextView.setText(prod.getDescription());
//                Picasso.with(getActivity()).load(prod.image_url).into(imageView);
            }
        }
    }
}
