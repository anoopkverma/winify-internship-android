package com.example.winify.cvsi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.interfaces.IRetrofitTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Maniak extends AppCompatActivity {

    private ListDto<ProductTemplate> listdto = new ListDto<ProductTemplate>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maniak);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.191:8080/cvsi-server/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        IRetrofitTest retrofitTest = retrofit.create(IRetrofitTest.class);

        Call<ListDto<ProductTemplate>> productList = retrofitTest.getAllProducts();





        productList.enqueue(new Callback<ListDto<ProductTemplate>>() {
            @Override
            public void onResponse(Call<ListDto<ProductTemplate>> call, Response<ListDto<ProductTemplate>> response) {
                listdto.setStatus(response.body().getStatus());
                listdto.setError(response.body().getError());
                listdto.setList(response.body().getList());
            }
            @Override
            public void onFailure(Call<ListDto<ProductTemplate>> call, Throwable t) {
            }
        });


        System.out.println();


    }

}
