package com.example.dev4dw.http;


import com.example.dev4dw.bean.lottery.LotteryTypeBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {
    /**
     * type:http://apis.juhe.cn/lottery/types
     */
    @GET("types")
    Call<LotteryTypeBean> getLotteryType(
            @Query("key") String id
    );
}
