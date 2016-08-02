package com.example.winify.cvsi.controllers;

import android.util.Log;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.interfaces.IRetrofitTest;
import com.example.winify.cvsi.interfaces.IUser;
import com.example.winify.cvsi.model.User;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diana on 7/14/16.
 */
public class UserController {

    public void postUser(AuthorizationClientRequest event) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.191:8000/dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IUser retrofitTest = retrofit.create(IUser.class);

        Call<ServerResponseStatus> call = retrofitTest.postUser(event);
        call.enqueue(new Callback<ServerResponseStatus>() {
            @Override
            public void onResponse(Call<ServerResponseStatus> call, Response<ServerResponseStatus> response) {
                Log.i("UserController", response.body().getStatus());
            }

            @Override
            public void onFailure(Call<ServerResponseStatus> call, Throwable t) {

            }
        });

    }


}
