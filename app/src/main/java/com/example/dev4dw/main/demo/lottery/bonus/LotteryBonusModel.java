package com.example.dev4dw.main.demo.lottery.bonus;


import com.example.dev4dw.bean.lottery.LotteryBonusBean;
import com.example.dev4dw.http.ApiService;
import com.example.dev4dw.http.RetrofitManager;
import com.example.dev4dw.utils.Config;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LotteryBonusModel extends LotteryBonusContact.BModel {

    @Override
    void loadBonus(String id, String res, String no, final LotteryBonusContact.LotteryBonusListener listener) {
        RetrofitManager.getInstance().create(ApiService.class)
                .bonusLottery(Config.JUHE_KEY,id,no,res)
                .enqueue(new Callback<LotteryBonusBean>() {
                    @Override
                    public void onResponse(Call<LotteryBonusBean> call, Response<LotteryBonusBean> response) {
                        listener.loadSuccess(response.body().getResult());
                    }

                    @Override
                    public void onFailure(Call<LotteryBonusBean> call, Throwable t) {

                    }
                });
    }
}
