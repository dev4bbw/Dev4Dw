package com.example.dev4dw.main.demo.lottery.type;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.main.demo.lottery.LotteryContact;

import java.util.List;

public interface LotteryTypeContact {
    interface TView extends BaseView{
        void getLotteryTypeResult(List<LotteryTypeBean.ResultBean> typeList);
    }
    abstract class TPresenter extends BasePresenter<TView>{
        abstract void getLotteryType();
    }
    abstract class TModel extends BaseModel{
        abstract void loadLotteryType(LotteryTypeContact.LoadTypeInterface listener);
    }
    interface LoadTypeInterface{
        void loadTypeResult(List<LotteryTypeBean.ResultBean> resultBeanList);
        void loadFail(String error);
    }
}
