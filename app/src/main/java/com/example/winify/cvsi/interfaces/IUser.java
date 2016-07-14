package com.example.winify.cvsi.interfaces;

import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by diana on 7/14/16.
 */
public interface IUser {
    @POST("user")
    Call<ServerResponseStatus> postUser(@Body AuthorizationClientRequest user);
}
