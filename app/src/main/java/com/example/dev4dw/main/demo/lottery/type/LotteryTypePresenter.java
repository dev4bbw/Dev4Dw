package com.example.dev4dw.main.demo.lottery.type;

import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.main.demo.lottery.LotteryContact;
import com.example.dev4dw.main.demo.lottery.LotteryModel;

import java.util.List;

public class LotteryTypePresenter extends LotteryTypeContact.TPresenter {
    private LotteryTypeModel mModel;

    LotteryTypePresenter() {
        mModel = new LotteryTypeModel();
    }

    @Override
    void getLotteryType() {
//        mModel.loadLotteryType(new LotteryContact.LoadTypeInterface() {
//            @Override
//            public void loadTypeResult(List<LotteryTypeBean.ResultBean> resultBeanList) {
//                getView().getLotteryType(resultBeanList);
//            }
//
//            @Override
//            public void loadFail(String error) {
//                Log.d("FAIL",error);
//            }
//        });
        mModel.postLotteryType(new LotteryTypeContact.LoadTypeInterface() {
            @Override
            public void loadTypeResult(List<LotteryTypeBean.ResultBean> resultBeanList) {
                getView().getLotteryTypeResult(resultBeanList);
            }

            @Override
            public void loadFail(String error) {

            }
        });
    }
}
