package com.example.winify.cvsi;

/**
 * Created by diana on 6/25/16.
 */
public class BuyPost {

    protected float price;
    protected static final  String NAME_PREFIX = "Tilte_";
    protected static final String DESCRIPTION_PREFIX = "Descripiton_";
    protected static final String PRICE_PREFIX = "Price_";

    public void setTitle(String title) {
        this.title = title;
    }

    protected String title;

    public void setDescription(String description) {
        this.description = description;
    }

    protected String description;

    public void setPrice(float price) {
        this.price = price;
    }

}
