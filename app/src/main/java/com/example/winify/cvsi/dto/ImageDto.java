package com.example.winify.cvsi.dto;


import com.example.winify.cvsi.dto.error.ServerResponseStatus;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by Artemie on 28.06.2016.
 */
public class ImageDto extends ServerResponseStatus implements Serializable {
    private String imgType;
    private Blob img;
    private Long createdDate;

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

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }
}
