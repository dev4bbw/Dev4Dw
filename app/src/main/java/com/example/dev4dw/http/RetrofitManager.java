package com.example.dev4dw.http;

import com.example.dev4dw.utils.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    public static RetrofitManager mInstance;
    private Retrofit mRetrofit;

    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkhttpClient())
                .build();

    }

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }
    private OkHttpClient getOkhttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder
                .addInterceptor(getHttpLoggingInterceptor())  //可设置可选项
//                .addInterceptor(getInterceptor())
                //.addInterceptor(new BaseInterceptor())  自定义拦截器
//                .addInterceptor(new CommonParamsInterceptor(,))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }
    private Interceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
    private Interceptor getInterceptor(){
        Interceptor interceptor =new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .build();
                return chain.proceed(request);
            }
        };
        return interceptor;
    }
    public <T>T create(Class<T> clazz){
        return mRetrofit.create(clazz);
    }
}
