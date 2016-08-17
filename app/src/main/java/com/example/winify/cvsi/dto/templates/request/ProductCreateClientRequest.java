package com.example.winify.cvsi.dto.templates.request;


import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artemie on 07.07.2016.
 */
public class ProductCreateClientRequest implements Serializable {

    private String title;
    private String description = "new product 0";
    private CurrencyEnum currency = CurrencyEnum.EUR;
    private Long price = null;
    private Boolean borrow = true;
    private Long limitDate = null ;
    private List<CategoryEnum> categoryEnumList = new ArrayList<CategoryEnum>();
    private Long createdDate = null;
    private Long updatedDate = null;

    public ProductCreateClientRequest() {
        title = "product_new0";
        description = "new product 0";
        currency = CurrencyEnum.EUR;
        price = null;
        borrow = true;
        limitDate = null ;
        categoryEnumList.add(CategoryEnum.BORROW);
        createdDate = null;
        updatedDate = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getBorrow() {
        return this.borrow;
    }

    public void setBorrow(Boolean borrow) {
        borrow = borrow;
    }

    public Long getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Long limitDate) {
        this.limitDate = limitDate;
    }

    public List<CategoryEnum> getCategoryEnumList() {
        return categoryEnumList;
    }

    public void setCategoryEnumList(List<CategoryEnum> categoryEnumList) {
        this.categoryEnumList = categoryEnumList;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }
}
