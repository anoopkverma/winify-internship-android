package com.example.winify.cvsi.interfaces;

import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.model.LoginUserModel;
import com.example.winify.cvsi.model.ResponseUser;
import com.example.winify.cvsi.model.TemporaryUser;
import com.example.winify.cvsi.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by diana on 7/14/16.
 */
public interface IUser {
    @POST("user")
    Call<ServerResponseStatus> postUser(@Body AuthorizationClientRequest user);

    @POST("login")
    Call<ResponseUser> log(@Body LoginUserModel user);
}
