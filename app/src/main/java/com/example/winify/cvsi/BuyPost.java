package com.example.winify.cvsi;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by diana on 6/25/16.
 */
public class BuyPost implements Serializable {

    protected String title;
    protected String description;
    protected Bitmap bitmap;


    private static final long serialVersionUID = 465489764;
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
