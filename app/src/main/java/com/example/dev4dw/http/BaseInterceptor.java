package com.example.dev4dw.http;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpurl = request.url();
        Request.Builder builder = request.newBuilder();
        List<String> headervals = request.headers("baseurl");
        if (headervals != null && headervals.size() > 0) {
            builder.removeHeader("baseurl");
            String headerval = headervals.get(0);
            HttpUrl newBaseurl = null;
//            if ()
            newBaseurl = oldHttpurl;

            HttpUrl newFullurl = oldHttpurl
                    .newBuilder()
                    .scheme("https")
                    .host(newBaseurl.host())
                    .port(newBaseurl.port())
                    .build();
            Log.e("xyh1","intercept:"+newFullurl.toString());
            return chain.proceed(builder.url(newFullurl).build());
        }
        return chain.proceed(request);
    }
}
