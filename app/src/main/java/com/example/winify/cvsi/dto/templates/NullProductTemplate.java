package com.example.winify.cvsi.dto.templates;

import android.util.Log;

import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diana on 8/4/16.
 */
public class NullProductTemplate extends AbstractProductTemplate {

    public NullProductTemplate(AbstractProductTemplate prod) {
        this.id = prod.getId();
        this.title = prod.getTitle();
        this.description = prod.getDescription();
        this.currency = prod.getCurrency();
        this.price = prod.getPrice();
        this.borrow = prod.getBorrow();
        this.limitDate = prod.getLimitDate();
        this.categoryEnumList = prod.getCategoryEnumList();
        this.userName = prod.getUserName();
        this.createdDate = prod.getCreatedDate();
        this.updatedDate = prod.getUpdatedDate();
    }

    @Override
    public Long getId() {
        Log.e("NullProductTemplate","getId() returns null.");
        return (long) 0;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        Log.e("NullProductTemplate","getTitle() returns null.");
        return  this.title == null ? "Title" : this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        Log.e("NullProductTemplate","getDescription() returns null.");
        return  this.description == null ? "Title" : this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public CurrencyEnum getCurrency() {
        Log.e("NullProductTemplate","getCurrency() returns null.");
        return  this.currency == null ? CurrencyEnum.EUR : this.currency;
    }

    @Override
    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public Long getPrice() {
        Log.e("NullProductTemplate","getPrice() returns null.");
        return  this.price == null ? (long) 0 : this.price;
    }

    @Override
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public Boolean getBorrow() {
        Log.e("NullProductTemplate","getBorrow() returns null.");
        return this.borrow == null ? false : this.borrow;
    }

    @Override
    public void setBorrow(Boolean borrow) {
        this.borrow = borrow;
    }

    @Override
    public Long getLimitDate() {
        Log.e("NullProductTemplate","getLimitDate() returns null.");
        return this.limitDate == null ? (long) 0 : this.limitDate;
    }

    @Override
    public void setLimitDate(Long limitDate) {
        this.limitDate = limitDate;
    }

    @Override
    public List<CategoryEnum> getCategoryEnumList() {
        Log.e("NullProductTemplate","getCategoryEnumList() returns null.");
        List<CategoryEnum> categ = new ArrayList<CategoryEnum>();
        categ.add(CategoryEnum.BORROW);
        return this.categoryEnumList == null ? categ : this.categoryEnumList;
    }

    @Override
    public void setCategoryEnumList(List<CategoryEnum> categoryEnumList) {
        this.categoryEnumList = categoryEnumList;
    }

    @Override
    public Long getCreatedDate() {
        Log.e("NullProductTemplate","getCreatedDate() returns null.");
        return this.createdDate == null ? (long) 0 : this.createdDate;
    }

    @Override
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Long getUpdatedDate() {
        Log.e("NullProductTemplate","getUpdatedDate() returns null.");
        return this.updatedDate == null ? (long) 0 : this.updatedDate;
    }

    @Override
    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String getUserName() {
        Log.e("NullProductTemplate","getUserName() returns null.");
        return this.userName == null ? "username" : this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
