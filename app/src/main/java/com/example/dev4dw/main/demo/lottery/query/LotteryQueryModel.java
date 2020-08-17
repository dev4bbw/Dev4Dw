package com.example.dev4dw.main.demo.lottery.query;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.bean.lottery.LotteryHistoryBean;
import com.example.dev4dw.bean.lottery.LotteryQueryBean;
import com.example.dev4dw.http.ApiService;
import com.example.dev4dw.http.RetrofitManager;
import com.example.dev4dw.utils.Config;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LotteryQueryModel extends LotteryQueryContact.QModel {

    @Override
    void loadQueryLottery(String qid, String qno, final LotteryQueryContact.LoadQueryListener listener) {
        RetrofitManager.getInstance().create(ApiService.class)
                .queryLottery(Config.JUHE_KEY,qid,qno)
                .enqueue(new Callback<LotteryQueryBean>() {
                    @Override
                    public void onResponse(Call<LotteryQueryBean> call, Response<LotteryQueryBean> response) {
                        listener.loadSuccess(response.body().getResult());
                    }

                    @Override
                    public void onFailure(Call<LotteryQueryBean> call, Throwable t) {
                        listener.loadFail();
                    }
                });


    }

    @Override
    void loadHistoryLottery(String id, String page, final LotteryQueryContact.LoadHistoryListener listener) {
        RetrofitManager.getInstance().create(ApiService.class)
                .historyLottery(Config.JUHE_KEY,id,page,"20")
                .enqueue(new Callback<LotteryHistoryBean>() {
                    @Override
                    public void onResponse(Call<LotteryHistoryBean> call, Response<LotteryHistoryBean> response) {
                        listener.loadSuccess(response.body().getResult());
                    }

                    @Override
                    public void onFailure(Call<LotteryHistoryBean> call, Throwable t) {

                    }
                });
    }
}
