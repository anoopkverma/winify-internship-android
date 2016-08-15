package com.example.winify.cvsi.controllers;

import android.util.Log;

import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.interfaces.IUser;
import com.example.winify.cvsi.model.User;;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by diana on 7/14/16.
 */
public class UserController {

    private Retrofit retrofit;
    private IUser retrofitIUser;
    private OkHttpClient httpClient;
    private static final String BASE_URL = "http://192.168.3.191:8000/dev/";

    public UserController() {

         this.httpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BODY))
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.retrofitIUser = retrofit.create(IUser.class);
    }

    public void postUser(AuthorizationClientRequest event) {

        Call<ServerResponseStatus> call = retrofitIUser.postUser(event);
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

    public void login() {
        User fakeUser = new User();
        fakeUser.setEmail("user1@example.com");
        fakeUser.setPassword("12345678");
        Call<User> call = retrofitIUser.login(fakeUser);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


}
