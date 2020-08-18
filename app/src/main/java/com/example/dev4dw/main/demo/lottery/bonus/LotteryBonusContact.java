package com.example.dev4dw.main.demo.lottery.bonus;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.lottery.LotteryBonusBean;

public interface LotteryBonusContact {
    interface BView extends BaseView{
        void bonusResult(LotteryBonusBean.ResultBean resultBean);
    }
    abstract class BPresenter extends BasePresenter<BView>{
        abstract void getBonusResult(String id,String res, String no );
    }
    abstract class BModel extends BaseModel{
        abstract void loadBonus(String id,String res,String no,LotteryBonusContact.LotteryBonusListener listener);
    }
    interface LotteryBonusListener{
        void loadSuccess(LotteryBonusBean.ResultBean resultBean);
        void loadFail();
    }
}
