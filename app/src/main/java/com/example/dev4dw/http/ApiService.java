package com.example.dev4dw.http;


import com.example.dev4dw.bean.lottery.LotteryBonusBean;
import com.example.dev4dw.bean.lottery.LotteryHistoryBean;
import com.example.dev4dw.bean.lottery.LotteryQueryBean;
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

    @FormUrlEncoded
    @POST("lottery/query")
    Call<LotteryQueryBean> queryLottery(
            @Field("key") String key,
            @Field("lottery_id") String id,
            @Field("lottery_no") String no
    );

    @FormUrlEncoded
    @POST("lottery/history")
    Call<LotteryHistoryBean> historyLottery(
            @Field("key") String key,
            @Field("lottery_id") String id,
            @Field("page") String page,
            @Field("page_size") String size

    );

    @FormUrlEncoded
    @POST("lottery/bonus")
    Call<LotteryBonusBean> bonusLottery(
            @Field("key") String key,
            @Field("lottery_id") String id,
            @Field("lottery_no") String no,
            @Field("lottery_res") String res

    );
}

