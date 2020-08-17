package com.example.dev4dw.main.demo.lottery;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;

import java.util.List;

public interface LotteryContact {
    interface LView extends BaseView{
    }
    abstract class LPresenter extends BasePresenter<LView>{

    }
    abstract class LModel extends BaseModel{

    }
}
