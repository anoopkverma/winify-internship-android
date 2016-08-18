package com.example.winify.cvsi.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.adapters.ListItemsAdapter;
import com.example.winify.cvsi.dto.templates.NullProductTemplate;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.squareup.picasso.Picasso;

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
                    getTheExtraBorrow(view);
                } else {
                    getTheExtraSellBuy(view);
                }
            }
        }


        return view;
    }

    public void getTheExtraSellBuy(View view) {
        if (getActivity().getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            prod = (AbstractProductTemplate) getActivity().getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            TextView titleTextView = (TextView) view.findViewById(R.id.title_tvbs);
            TextView descriptionTextView = (TextView) view.findViewById(R.id.description_tvbs);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_viewbs);
            Picasso.with(getActivity()).load("http://192.168.3.191:8080/cvsi-server/product/" + prod.getId().toString() + "/image/default").into(imageView);
            TextView startDateTV = (TextView) view.findViewById(R.id.datebs);
            TextView priceTV = (TextView) view.findViewById(R.id.price_tvbs);
            Button currentyTypeButton = (Button) view.findViewById(R.id.currencybs);
            TextView userName = (TextView) view.findViewById(R.id.username_tvbs);
            if (titleTextView != null && descriptionTextView != null && priceTV != null) {
                titleTextView.setText(prod.getTitle());
                descriptionTextView.setText(prod.getDescription());
                startDateTV.setText(prod.getCreatedDate().toString());
                priceTV.setText(String.valueOf(prod.getPrice()));
                currentyTypeButton.setText(prod.getCurrency().toString());
                userName.setText(prod.getUserName());
//                borrowTypeButton.setText(prod.getCategoryEnumList());
//                Picasso.with(getActivity()).load(prod.image_url).into(imageView);
            }
        }
    }

    public void getTheExtraBorrow(View view) {
        if (getActivity().getIntent().hasExtra(ListItemsAdapter.ITEM_POST)) {
            prod = (AbstractProductTemplate) getActivity().getIntent().getSerializableExtra(ListItemsAdapter.ITEM_POST);

            TextView titleTextView = (TextView) view.findViewById(R.id.title_tv);
            TextView descriptionTextView = (TextView) view.findViewById(R.id.description_tv);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
            TextView startDateTV = (TextView) view.findViewById(R.id.starting_date);
            TextView endDateTV = (TextView) view.findViewById(R.id.end_date);
            TextView priceTV = (TextView) view.findViewById(R.id.price_text_v);
            Button currentyTypeButton = (Button) view.findViewById(R.id.currency_button);
            Button borrowTypeButton = (Button) view.findViewById(R.id.button_type);
            TextView userName = (TextView) view.findViewById(R.id.username_tv);
            if (titleTextView != null && descriptionTextView != null && priceTV != null) {
                titleTextView.setText(prod.getTitle());
                descriptionTextView.setText(prod.getDescription());
                if (prod.getLimitDate() != null && prod.getCreatedDate() != null) {
                    startDateTV.setText(prod.getCreatedDate().toString());
                    endDateTV.setText(prod.getLimitDate().toString());
                }
                priceTV.setText(String.valueOf(prod.getPrice()));
                currentyTypeButton.setText(prod.getCurrency().toString());
                userName.setText(prod.getUserName());
//                borrowTypeButton.setText(prod.getCategoryEnumList());
//                Picasso.with(getActivity()).load(prod.image_url).into(imageView);
            }
        }
    }
}
