package com.example.winify.cvsi.interfaces;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.dto.templates.request.ProductCreateClientRequest;
import com.example.winify.cvsi.model.LoginUserModel;
import com.example.winify.cvsi.model.ResponseUser;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by diana on 7/11/16.
 */
public interface IRetrofit {

    @GET("product")
    Call<ListDto<ProductTemplate>> getAllProducts(
                                                  @Query("count") Long count
    );

    @Multipart
    @POST("user/image")
    Call<ResponseBody> postImage(@Part MultipartBody.Part file
//            , @Part("name") RequestBody name
    );

    @POST("product")
    Call<ServerResponseStatus> postProduct(@Body ProductCreateClientRequest prod);

    @GET("product/{productId}/image/default")
    Call<ResponseBody> getProductImage(@Path("productId") String string);

    @POST("user")
    Call<ServerResponseStatus> postUser(@Body AuthorizationClientRequest user);

    @POST("login")
    Call<ResponseUser> log(@Body LoginUserModel user);





}
