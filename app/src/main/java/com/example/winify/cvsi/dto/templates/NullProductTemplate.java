package com.example.winify.cvsi.dto.templates;

import android.util.Log;

import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        this.categories = prod.getCategories();
        this.userName = prod.getUserName();
        this.createdDate = prod.getCreatedDate();
        this.updatedDate = prod.getUpdatedDate();
    }

    @Override
    public Long getId() {
        return this.id ;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return  this.title == null ? "Title" : this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return  this.description == null ? "Title" : this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public CurrencyEnum getCurrency() {
        return  this.currency == null ? CurrencyEnum.EUR : this.currency;
    }

    @Override
    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public Long getPrice() {
        return  this.price == null ? (long) 0 : this.price;
    }

    @Override
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public Long getLimitDate() {
        return this.limitDate == null ? (long) 0 : this.limitDate;
    }

    @Override
    public void setLimitDate(Long limitDate) {
        this.limitDate = limitDate;
    }

    @Override
    public Long getCreatedDate() {
        return this.createdDate == null ? (long) 0 : this.createdDate;
    }

    @Override
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Long getUpdatedDate() {
        return this.updatedDate == null ? (long) 0 : this.updatedDate;
    }

    @Override
    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String getUserName() {
        return this.userName == null ? "username" : this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Set<CategoryEnum> getCategories() {
        return categories == null ? new HashSet<CategoryEnum>() : this.categories;
    }

    @Override
    public void setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
    }

    @Override
    public Boolean getBorrow() {
        return this.borrow == null ? false : this.borrow;
    }
    @Override
    public boolean isNil() {
        return true;
    }
}
