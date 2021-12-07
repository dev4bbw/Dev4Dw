package com.example.apublic.base;

import android.util.Log;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MoreBaseUrlInterceptor implements Interceptor {
    private static final String TAG = "MoreBaseUrlInterceptor";

    private String baseStringURL = "";

    public MoreBaseUrlInterceptor(String baseURL) {
        baseStringURL = baseURL;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取原始的originalRequest
        Request originalRequest = chain.request();
        RequestBody body = originalRequest.body();
        //获取老的url
        HttpUrl oldUrl = originalRequest.url();
        //获取originalRequest的创建者builder
        Request.Builder builder = originalRequest.newBuilder();

        //获取头信息的集合如：manage,mdffx
        List<String> urlnameList = originalRequest.headers("urlname");

        if (urlnameList != null && urlnameList.size() > 0) {
            RequestBody newBody = null;
            builder.removeHeader("urlname");
            String urlname = urlnameList.get(0);
            HttpUrl baseURL = null;
            if ("juhe".equals(urlname)) {
                baseURL = HttpUrl.parse(baseStringURL);
                if (body instanceof FormBody) {
                    newBody = addParamsToFormBody((FormBody) body);
                } else if (body instanceof MultipartBody) {
                    newBody = addParamsToMultipartBody((MultipartBody) body);
                }
            } else {
                baseURL = HttpUrl.parse(baseStringURL);
            }
            HttpUrl.Builder builder1 = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())//http协议如：http或者https
                    .host(baseURL.host())//主机地址
                    ;

            HttpUrl newHttpUrl = builder1.build();
            //获取处理后的新newRequest
            Request newRequest = builder.url(newHttpUrl).method(originalRequest.method(),newBody).build();
            return chain.proceed(newRequest);
        } else {
            return chain.proceed(originalRequest);
        }
    }

    /**
     * 为MultipartBody类型请求体添加参数
     *
     * @param body
     * @return
     */
    private MultipartBody addParamsToMultipartBody(MultipartBody body) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        //添加key
        builder.addFormDataPart("key", Config.JUHE_NEWS_KEY);
        //添加原请求体
        for (int i = 0; i < body.size(); i++) {
            builder.addPart(body.part(i));
        }
        return builder.build();
    }

    /**
     * 为FormBody类型请求体添加参数
     *
     * @param body
     * @return
     */
    private FormBody addParamsToFormBody(FormBody body) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加appcode
        builder.add("key",  Config.JUHE_NEWS_KEY);
        //添加原请求体
        for (int i = 0; i < body.size(); i++) {
            builder.addEncoded(body.encodedName(i), body.encodedValue(i));
        }
        return builder.build();

    }
}
