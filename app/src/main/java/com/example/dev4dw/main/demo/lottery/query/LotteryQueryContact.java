package com.example.dev4dw.main.demo.lottery.query;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.lottery.LotteryHistoryBean;
import com.example.dev4dw.bean.lottery.LotteryQueryBean;

public interface LotteryQueryContact {
    interface QView extends BaseView{
        void queryResult(LotteryQueryBean.ResultBean result);
        void historyResult(LotteryHistoryBean.ResultBean reult);
    }
    abstract class QPresenter extends BasePresenter<QView>{
        abstract void queryLottery(String qid,String qno);
        abstract void historyLottery(String id,String page);
    }
    abstract class QModel extends BaseModel{
        abstract void loadQueryLottery(String qid,String qno,LotteryQueryContact.LoadQueryListener listener);
        abstract void loadHistoryLottery(String id,String page,LoadHistoryListener listener);
    }
    interface LoadQueryListener{
        void loadSuccess(LotteryQueryBean.ResultBean result);
        void loadFail();
    }
    interface LoadHistoryListener{
        void loadSuccess(LotteryHistoryBean.ResultBean result);
        void loadFail();
    }
}
