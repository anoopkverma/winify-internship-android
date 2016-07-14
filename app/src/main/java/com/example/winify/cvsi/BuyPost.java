package com.example.winify.cvsi;

import android.graphics.Bitmap;

import com.example.winify.cvsi.model.Image;
import com.example.winify.cvsi.model.User;
import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by diana on 6/25/16.
 */
public class BuyPost implements Serializable {

    public String image_url;
    private Long id;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public Boolean getBorrow() {
        return isBorrow;
    }

    public void setBorrow(Boolean borrow) {
        isBorrow = borrow;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public List<CategoryEnum> getCategoryEnumList() {
        return categoryEnumList;
    }

    public void setCategoryEnumList(List<CategoryEnum> categoryEnumList) {
        this.categoryEnumList = categoryEnumList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private String title;
    private String description;
    private Long price;
    private CurrencyEnum currency;
    private Boolean isBorrow;
    private Boolean isArchived;
    private Date createdDate;
    private Date limitDate;
    private Date updatedDate;
    private List<CategoryEnum> categoryEnumList = new ArrayList<CategoryEnum>();
    private List<Image> imageList = new ArrayList<Image>();
    private User user;

    private static final long serialVersionUID = 465489764;


}
