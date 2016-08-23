package com.example.winify.cvsi.controllers;

import android.app.Application;

/**
 * Created by diana on 8/17/16.
 */
public class ApplicationController extends Application {

    private ProductController productController;
    private SessionManager sessionManager;

    @Override
    public void onCreate() {
        super.onCreate();
        productController = new ProductController(getApplicationContext());
    }
    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }
}
