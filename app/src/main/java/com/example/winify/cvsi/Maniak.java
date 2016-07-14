package com.example.winify.cvsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.interfaces.IUser;


import java.util.Date;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Maniak extends AppCompatActivity {

    public static ListDto<ProductTemplate> listdto = new ListDto<ProductTemplate>();
    private ProductController productController;
    TextView textView;
    Button button;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maniak);
        textView = (TextView) findViewById(R.id.hz_tv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.191:8080/cvsi-server/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IUser retrofitTest = retrofit.create(IUser.class);

//        retrofitTest.postUser(new AuthorizationClientRequest(
//                "email@gmail.ru",
//                "password1",
//                "123456789",
//                "usernamaersdhrosdhie",
//                "namename",
//                "surnaem",
//                new Date().getTime()));

        Call<ServerResponseStatus> call = retrofitTest.postUser(new AuthorizationClientRequest(
                "emailfw1@gmail.ru",
                "password11",
                "1234567891",
                "usernamaersdhrosdhie1",
                "namename1",
                "surnaem1",
                new Date().getTime()));
        call.enqueue(new Callback<ServerResponseStatus>() {
            @Override
            public void onResponse(Call<ServerResponseStatus> call, Response<ServerResponseStatus> response) {
                Log.i("UserController", response.body().getStatus());
            }

            @Override
            public void onFailure(Call<ServerResponseStatus> call, Throwable t) {

            }
        });
//

    }


}
