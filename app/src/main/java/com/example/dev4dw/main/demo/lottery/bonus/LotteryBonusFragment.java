package com.example.dev4dw.main.demo.lottery.bonus;

import android.view.View;

import com.example.dev4dw.R;
import com.example.dev4dw.base.BaseFragment;

public class LotteryBonusFragment extends BaseFragment<LotteryBonusContact.BView, LotteryBonusContact.BPresenter> implements LotteryBonusContact.BView {
    @Override
    public int getLayoutID() {
        return R.layout.fragment_query_bonus;
    }

    @Override
    public LotteryBonusContact.BPresenter createPresenter() {
        return new LotteryBonusPresenter();
    }

    @Override
    public LotteryBonusContact.BView createView() {
        return this;
    }

    @Override
    public void init(View view) {

    }
}
