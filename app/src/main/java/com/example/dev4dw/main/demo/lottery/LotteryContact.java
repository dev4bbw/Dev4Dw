package com.example.dev4dw.main.demo.lottery;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;

import java.util.List;

public interface LotteryContact {
    interface LView extends BaseView{
        void getLotteryType(List<LotteryTypeBean.ResultBean> typeList);
    }
    abstract class LPresenter extends BasePresenter<LView>{
        abstract void getLotteryType();

    }
    abstract class LModel extends BaseModel{
        abstract void loadLotteryType(LoadTypeInterface listener);

    }
    interface LoadTypeInterface{
        void loadTypeResult(List<LotteryTypeBean.ResultBean> resultBeanList);
        void loadFail(String error);
    }
}
