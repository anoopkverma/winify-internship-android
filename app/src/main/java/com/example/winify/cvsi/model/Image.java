package com.example.winify.cvsi.model;


import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by Artemie on 25.06.2016.
 */
public class Image implements Serializable {
    private Long id;
    private String imgType;
    private Blob img;
    private Date createdDate;
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
