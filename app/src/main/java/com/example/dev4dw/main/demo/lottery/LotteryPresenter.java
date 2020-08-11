package com.example.dev4dw.main.demo.lottery;

import android.util.Log;

import com.example.dev4dw.bean.lottery.LotteryTypeBean;

import java.util.List;

class LotteryPresenter extends LotteryContact.LPresenter {
    private LotteryModel mModel;

    LotteryPresenter() {
        mModel = new LotteryModel();
    }

    @Override
    void getLotteryType() {
        mModel.loadLotteryType(new LotteryContact.LoadTypeInterface() {
            @Override
            public void loadTypeResult(List<LotteryTypeBean.ResultBean> resultBeanList) {
                getView().getLotteryType(resultBeanList);
            }

            @Override
            public void loadFail(String error) {
                Log.d("FAIL",error);
            }
        });
    }
}
