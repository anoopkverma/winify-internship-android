package com.example.winify.cvsi.dto.builder;


import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.dto.templates.NullProductTemplate;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Artemie on 28.06.2016.
 */
public class ProductBuilder {

//    public AbstractProductTemplate getProduct(AbstractProductTemplate productCreateClientRequest) {
//        AbstractProductTemplate product = new NullProductTemplate();
//        product.setTitle(productCreateClientRequest.getTitle());
//        product.setDescription(productCreateClientRequest.getDescription());
//        product.setPrice(productCreateClientRequest.getPrice());
//        product.setCurrency(productCreateClientRequest.getCurrency());
//        product.setBorrow(productCreateClientRequest.getBorrow());
//        product.setCreatedDate(productCreateClientRequest.getCreatedDate() == null ? new Date(new Date().getTime() - (1000L * 60)) : new Date(productCreateClientRequest.getCreatedDate()));
//        product.setLimitDate(productCreateClientRequest.getLimitDate() == null ? null : new Date(productCreateClientRequest.getLimitDate()));
//        product.setUpdatedDate(productCreateClientRequest.getUpdatedDate() == null ? null : new Date(productCreateClientRequest.getUpdatedDate()));
//        product.setCategories(productCreateClientRequest.getCategories());
//        return product;
//    }
//
//    public AbstractProductTemplate getProductTemplate(Product product) {
//        AbstractProductTemplate productTemplateResponse = new AbstractProductTemplate();
//        productTemplateResponse.setId(product.getId());
//        productTemplateResponse.setTitle(product.getTitle());
//        productTemplateResponse.setDescription(product.getDescription());
//        productTemplateResponse.setCurrency(product.getCurrency());
//        productTemplateResponse.setPrice(product.getPrice());
//        productTemplateResponse.setBorrow(product.getBorrow());
//        productTemplateResponse.setLimitDate(product.getLimitDate() == null ? null : product.getLimitDate().getTime());
//        productTemplateResponse.setCategories(product.getCategories());
//        productTemplateResponse.setCreatedDate(product.getCreatedDate().getTime());
//        productTemplateResponse.setUpdatedDate(product.getUpdatedDate() == null ? null : product.getUpdatedDate().getTime());
//        productTemplateResponse.setUserName(product.getUser().getUsername());
//        return productTemplateResponse;
//    }
}