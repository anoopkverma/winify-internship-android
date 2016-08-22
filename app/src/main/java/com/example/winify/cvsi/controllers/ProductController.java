package com.example.winify.cvsi.controllers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaderFactory;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.dto.templates.request.ProductCreateClientRequest;
import com.example.winify.cvsi.interfaces.IRetrofit;
import com.example.winify.cvsi.model.ResponseUser;

import java.io.File;
import java.io.IOException;

import de.greenrobot.event.EventBus;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by diana on 7/13/16.
 */
public class ProductController {

    private Retrofit retrofit;
    private IRetrofit iRetrofit;
    private OkHttpClient okHttpClient;
    private String BASE_URL = "http://192.168.3.191:8080/cvsi-server/";
    private SessionManager sessionManager;
    private Context context;
    private String imagePath;

    public IRetrofit getiRetrofit() {
        return  this.iRetrofit;
    }

    public ProductController(Context _context, final String authToken) {
        this.context = _context;
        this.sessionManager = new SessionManager(this.context);
        this.okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .header("X-Auth-Token", authToken)
                                .method(original.method(), original.body());

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                })
                .build();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.iRetrofit = retrofit.create(IRetrofit.class);
    }

    public void getProductDTO() {

        Call<ListDto<ProductTemplate>> productList = iRetrofit.getAllProducts((long) 0);
        productList.enqueue(new Callback<ListDto<ProductTemplate>>() {
            @Override
            public void onResponse(Call<ListDto<ProductTemplate>> call, Response<ListDto<ProductTemplate>> response) {
                if (response.isSuccessful()) {
                    EventBus.getDefault().post(response.body());
                    Log.i("TAG", response.body().getList().get(0).getTitle());
                }
            }
            @Override
            public void onFailure(Call<ListDto<ProductTemplate>> call, Throwable t) {

            }
        });
    }

    public void createProduct(ProductCreateClientRequest event) {
        Call<ServerResponseStatus> call = iRetrofit.postProduct(event);
        call.enqueue(new Callback<ServerResponseStatus>() {
            @Override
            public void onResponse(Call<ServerResponseStatus> call, Response<ServerResponseStatus> response) {

            }

            @Override
            public void onFailure(Call<ServerResponseStatus> call, Throwable t) {

            }
        });
    }

    public void getProductDefaultImage(String productId, final String authToken, final String url, final ImageView imageView) {
        Call<ResponseBody> call = iRetrofit.getProductImage(productId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                getImage(context, authToken, url, imageView);
                Log.w("tagg", response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public static void getImage(Context context, final String authToken, String url, ImageView imageView) {
        GlideUrl glideUrl = new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("X-Auth-Token", authToken)
                .build());
        Glide.with(context).load(glideUrl).asBitmap().into(imageView);
    }

    public void postImage(String filePath, Uri uri) {
        File file = new File(filePath);

        RequestBody reqFile = RequestBody.create(MediaType.parse(context.getContentResolver().getType(uri)), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), reqFile);
        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "upload_test");

        retrofit2.Call<okhttp3.ResponseBody> req = iRetrofit.postImg(body);
        req.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // Do Something
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
