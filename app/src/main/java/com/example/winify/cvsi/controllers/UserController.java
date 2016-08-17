package com.example.winify.cvsi.controllers;

import android.content.Context;
import android.util.Log;

import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.interfaces.IRetrofit;
import com.example.winify.cvsi.model.LoginUserModel;
import com.example.winify.cvsi.model.ResponseUser;
;
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
    private IRetrofit iUser;
    private OkHttpClient okHttpClient;
    private String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";
    private ResponseUser responseUser;
    protected Context context;

    public UserController(Context context) {
        this.context = context;
        this.okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BODY))
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.iUser = retrofit.create(IRetrofit.class);
    }

    public void login(LoginUserModel user){
        iUser.log(user).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                SessionManager sessionManager = new SessionManager(context);
                if (!(response.body() == null)) {
                    sessionManager.saveToken(response.body().getToken());
                    sessionManager.saveUser(response.body().getUser());
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {

            }
        });
    }

    public ResponseUser getResponseUser() {
        return this.responseUser;
    }

    public void postUser(AuthorizationClientRequest event) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.191:8000/dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRetrofit retrofitTest = retrofit.create(IRetrofit.class);

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