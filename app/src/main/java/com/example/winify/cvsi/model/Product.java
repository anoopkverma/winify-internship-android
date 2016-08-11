package com.example.winify.cvsi.model;


import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Artemie on 25.06.2016.
 */
public class Product implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Long price;
    private CurrencyEnum currency;
    private Boolean Borrow;
    private Boolean isArchived;
    private Date createdDate;
    private Date limitDate;
    private Date updatedDate;
    private List<Image> imageList = new ArrayList<Image>();
    private User user;
    private Set<CategoryEnum> categories;

    public Product() {
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public Boolean getBorrow() {
        return Borrow;
    }

    public void setBorrow(Boolean isBorrow) {
        this.Borrow = isBorrow;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }


}
