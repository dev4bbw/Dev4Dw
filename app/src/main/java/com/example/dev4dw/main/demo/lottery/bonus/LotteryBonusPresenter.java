package com.example.dev4dw.main.demo.lottery.bonus;

import com.example.dev4dw.bean.lottery.LotteryBonusBean;

public class LotteryBonusPresenter extends LotteryBonusContact.BPresenter {
    LotteryBonusModel model;

    LotteryBonusPresenter(){
        model = new LotteryBonusModel();
    }

    void getBonusResult(String id,String res, String no ){
        model.loadBonus(id, res, no, new LotteryBonusContact.LotteryBonusListener() {
            @Override
            public void loadSuccess(LotteryBonusBean.ResultBean resultBean) {
                getView().bonusResult(resultBean);
            }

            @Override
            public void loadFail() {

            }
        });
    }
}
