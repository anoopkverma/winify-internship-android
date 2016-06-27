package com.example.winify.cvsi;

import java.io.Serializable;

/**
 * Created by diana on 6/25/16.
 */
public class BuyPost implements Serializable {

    protected float price;

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
