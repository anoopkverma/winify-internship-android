package com.example.winify.cvsi.dto.templates;


import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.util.List;
import java.util.Set;

/**
 * Created by Artemie on 01.07.2016.
 */
// Clasa template pentru un item din lista de producte
public class ProductTemplate extends AbstractProductTemplate {

    @Override
    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    @Override
    public void setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public CurrencyEnum getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    @Override
    public Long getPrice() {
        return price;
    }

    @Override
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public Long getLimitDate() {
        return limitDate;
    }

    @Override
    public void setLimitDate(Long limitDate) {
        this.limitDate = limitDate;
    }


    @Override
    public Long getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Long getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}



