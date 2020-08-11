package com.example.dev4dw.main.demo.lottery;

import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.http.ApiService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LotteryModel extends LotteryContact.LModel {
    private String TYPE_URL = "http://apis.juhe.cn/lottery/";
    private static final String KEY = "c438452e43e2f7d0ef039d9cc4ebd3f6";

    @Override
    void loadLotteryType(final LotteryContact.LoadTypeInterface listener) {
        //1.创建retrofit对象
        // 查看网络request 和 response 的具体的值
        //2.通过Retrofit实例创建接口服务对象
        //3.接口服务对象调用接口中方法，获得Call对象
        //4.Call对象执行请求（异步、同步请求）

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//设置查看日志的等级

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        okHttpBuilder.interceptors().add(logging);// 这句话是重点

        //可以自定义，可以使用okHttp 默认的timeout 10s
        okHttpBuilder.connectTimeout(10, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TYPE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())//gson转换器
                .build();

        retrofit.create(ApiService.class)
                .getLotteryType(KEY)
                .enqueue(new Callback<LotteryTypeBean>() {
                    @Override
                    public void onResponse(Call<LotteryTypeBean> call, Response<LotteryTypeBean> response) {
                        List<LotteryTypeBean.ResultBean> resultBeanList = response.body().getResult();
                        listener.loadTypeResult(resultBeanList);

                    }

                    @Override
                    public void onFailure(Call<LotteryTypeBean> call, Throwable t) {
                        listener.loadFail("fail");
                    }
                });

    }
}
