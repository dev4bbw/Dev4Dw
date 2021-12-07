package com.example.apublic.api;

import com.example.apublic.bean.home.NewsBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    /**
     *订单支付
     */
//    @Headers("urlname:juhe")
    @POST("toutiao/index")
    Observable<NewsBean> loadNews(@Body RequestBody requestBody);

//    /**
//     * type:http://apis.juhe.cn/lottery/types
//     */
//    @GET("lottery/types")
//    Call<LotteryTypeBean> getLotteryType(
//            @Query("key") String key
//    );
//
//    @FormUrlEncoded
//    @POST("lottery/types")
//    Call<LotteryTypeBean> postLotteryType(
//            @Field("key") String key
//    );
//
//    @FormUrlEncoded
//    @POST("lottery/query")
//    Call<LotteryQueryBean> queryLottery(
//            @Field("key") String key,
//            @Field("lottery_id") String id,
//            @Field("lottery_no") String no
//    );
//
//    @FormUrlEncoded
//    @POST("lottery/history")
//    Call<LotteryHistoryBean> historyLottery(
//            @Field("key") String key,
//            @Field("lottery_id") String id,
//            @Field("page") String page,
//            @Field("page_size") String size
//
//    );
//
//    @FormUrlEncoded
//    @POST("lottery/bonus")
//    Call<LotteryBonusBean> bonusLottery(
//            @Field("key") String key,
//            @Field("lottery_id") String id,
//            @Field("lottery_no") String no,
//            @Field("lottery_res") String res
//
//    );
}
