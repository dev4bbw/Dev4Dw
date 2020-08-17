package com.example.dev4dw.main.demo.lottery.query;

import com.example.dev4dw.bean.lottery.LotteryHistoryBean;
import com.example.dev4dw.bean.lottery.LotteryQueryBean;

public class LoterryQueryPresenter extends LotteryQueryContact.QPresenter {
    LotteryQueryModel model;
    LoterryQueryPresenter(){
        model = new LotteryQueryModel();
    }

    @Override
    void queryLottery(String qid, String qno) {
        model.loadQueryLottery(qid, qno, new LotteryQueryContact.LoadQueryListener() {
            @Override
            public void loadSuccess(LotteryQueryBean.ResultBean result) {
                getView().queryResult(result);
            }

            @Override
            public void loadFail() {

            }
        });
    }

    @Override
    void historyLottery(String id, String page) {
        model.loadHistoryLottery(id, page, new LotteryQueryContact.LoadHistoryListener() {
            @Override
            public void loadSuccess(LotteryHistoryBean.ResultBean result) {
                getView().historyResult(result);
            }

            @Override
            public void loadFail() {

            }
        });
    }
}
