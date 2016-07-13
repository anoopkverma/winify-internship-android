package com.example.winify.cvsi;

import android.util.Log;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.interfaces.IRetrofitTest;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diana on 7/13/16.
 */
public class ProductController {

    public void getProductDTO() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.191:8080/cvsi-server/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        IRetrofitTest retrofitTest = retrofit.create(IRetrofitTest.class);

        Call<ListDto<ProductTemplate>> productList = retrofitTest.getAllProducts((long) 0);


        productList.enqueue(new Callback<ListDto<ProductTemplate>>() {
            @Override
            public void onResponse(Call<ListDto<ProductTemplate>> call, Response<ListDto<ProductTemplate>> response) {
                if (response.isSuccessful()) {

                    EventBus.getDefault().post(response.body());
//                    Log.i("TAG", response.body().getList().get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Call<ListDto<ProductTemplate>> call, Throwable t) {

            }
        });
    }
}
