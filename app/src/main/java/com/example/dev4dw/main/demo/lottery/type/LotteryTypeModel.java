package com.example.dev4dw.main.demo.lottery.type;

import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.http.ApiService;
import com.example.dev4dw.http.RetrofitManager;
import com.example.dev4dw.utils.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LotteryTypeModel extends LotteryTypeContact.TModel {

    @Override
    void loadLotteryType(final LotteryTypeContact.LoadTypeInterface listener) {
        //1.创建retrofit对象
        // 查看网络request 和 response 的具体的值
        //2.通过Retrofit实例创建接口服务对象
        //3.接口服务对象调用接口中方法，获得Call对象
        //4.Call对象执行请求（异步、同步请求）
/*
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//设置查看日志的等级

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        okHttpBuilder.interceptors().add(logging);// 这句话是重点

        //可以自定义，可以使用okHttp 默认的timeout 10s
        okHttpBuilder.connectTimeout(10, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.LOTTERY_TYPE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())//gson转换器
                .build();

        retrofit.create(ApiService.class)
                .getLotteryType(Config.JUHE_KEY)
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
*/
        RetrofitManager.getInstance().create(ApiService.class)
                .getLotteryType(Config.JUHE_KEY)
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

    void postLotteryType(final LotteryTypeContact.LoadTypeInterface listener) {
        RetrofitManager.getInstance().create(ApiService.class)
                .postLotteryType(Config.JUHE_KEY)
                .enqueue(new Callback<LotteryTypeBean>() {
                    @Override
                    public void onResponse(Call<LotteryTypeBean> call, Response<LotteryTypeBean> response) {
                        listener.loadTypeResult(response.body().getResult());
                    }

                    @Override
                    public void onFailure(Call<LotteryTypeBean> call, Throwable t) {

                    }
                });
    }
}
