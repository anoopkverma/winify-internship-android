package com.example.winify.cvsi.abstractClasses;

import com.example.winify.cvsi.model.enums.CategoryEnum;
import com.example.winify.cvsi.model.enums.CurrencyEnum;

import java.io.Serializable;
import java.util.List;

/**
 * Created by diana on 8/4/16.
 */
public abstract class AbstractProductTemplate implements Serializable {

    protected Long id;
    protected String title;
    protected String description;
    protected CurrencyEnum currency;
    protected Long price;
    protected Boolean borrow;
    protected Long limitDate;
    protected List<CategoryEnum> categoryEnumList;
    protected String userName;
    protected Long createdDate;
    protected Long updatedDate;

    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract CurrencyEnum getCurrency();

    public abstract void setCurrency(CurrencyEnum currency);

    public abstract Long getPrice();

    public abstract void setPrice(Long price);

    public abstract Boolean getBorrow();

    public abstract void setBorrow(Boolean borrow);

    public abstract Long getLimitDate();

    public abstract void setLimitDate(Long limitDate);

    public abstract List<CategoryEnum> getCategoryEnumList();

    public abstract void setCategoryEnumList(List<CategoryEnum> categoryEnumList);

    public abstract Long getCreatedDate();

    public abstract void setCreatedDate(Long createdDate);

    public abstract Long getUpdatedDate();

    public abstract void setUpdatedDate(Long updatedDate);

    public abstract String getUserName();

    public abstract void setUserName(String userName);

    public abstract boolean isNil();
}
