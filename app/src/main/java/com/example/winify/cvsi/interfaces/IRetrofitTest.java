package com.example.winify.cvsi.interfaces;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by diana on 7/11/16.
 */
public interface IRetrofitTest {

    @GET("product/all")
    Call<ListDto<ProductTemplate>> getAllProducts();
}
