package com.example.winify.cvsi.dto;


import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.enums.ErrorEnum;

import java.io.Serializable;

/**
 * Created by Artemie on 28.06.2016.
 */
public class ProductDto extends ServerResponseStatus implements Serializable {

    private ProductTemplate productTemplate;

    public ProductDto(){}

    public ProductDto(ErrorEnum error, String status, ProductTemplate productTemplate){
        super(error,status);
        this.productTemplate = productTemplate;
    }

    public ProductDto(ServerResponseStatus serverResponseStatus,ProductTemplate productTemplate){
        super(serverResponseStatus);
        this.productTemplate = productTemplate;
    }

    public ProductTemplate getProductTemplate() {
        return productTemplate;
    }

    public void setProductTemplate(ProductTemplate productTemplate) {
        this.productTemplate = productTemplate;
    }
}
