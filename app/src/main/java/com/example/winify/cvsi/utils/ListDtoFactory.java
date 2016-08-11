package com.example.winify.cvsi.utils;

import com.example.winify.cvsi.abstractClasses.AbstractProductTemplate;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.NullProductTemplate;
import com.example.winify.cvsi.dto.templates.ProductTemplate;

/**
 * Created by diana on 8/4/16.
 */
public class ListDtoFactory {

    public static ListDto<AbstractProductTemplate> getProduct(ListDto<AbstractProductTemplate> prod) {
        ListDto<AbstractProductTemplate> dtoObj = new ListDto<>();
        for (int i = 0; i < prod.getList().size(); i++) {
            if(prod.getList().get(i).getBorrow() == null || prod.getList().get(i).getTitle() == null || prod.getList().get(i).getCurrency() == null ||
                    prod.getList().get(i).getCategories() == null || prod.getList().get(i).getCreatedDate() == null ||
                    prod.getList().get(i).getDescription() == null || prod.getList().get(i).getId() == null || prod.getList().get(i).getLimitDate() == null ||
                    prod.getList().get(i).getPrice() == null || prod.getList().get(i).getUpdatedDate() == null) {

                dtoObj.getList().add(new NullProductTemplate(prod.getList().get(i)));
            } else {
                dtoObj.getList().add(prod.getList().get(i));
            }
        }
        return dtoObj;
    }
}

