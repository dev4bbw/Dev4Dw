package com.example.dev4dw.http;


import com.example.dev4dw.bean.lottery.LotteryTypeBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {
    /**
     * type:http://apis.juhe.cn/lottery/types
     */
    @GET("lottery/types")
    Call<LotteryTypeBean> getLotteryType(
            @Query("key") String key
    );
    @FormUrlEncoded
    @POST("lottery/types")
    Call<LotteryTypeBean> postLotteryType(
            @Field("key") String key
    );
}
