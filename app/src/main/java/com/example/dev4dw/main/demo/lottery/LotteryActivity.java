package com.example.dev4dw.main.demo.lottery;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.lottery.LotteryTypeAdapter;
import com.example.dev4dw.base.BaseMvpActivity;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.http.ApiService;

import java.util.List;

public class LotteryActivity extends BaseMvpActivity<LotteryContact.LView, LotteryContact.LPresenter> implements LotteryContact.LView {
    //支持彩种接口
    //开奖结果查询
    //历史开奖结果查询
    //中奖计算器
    RecyclerView mRv;
    LotteryTypeAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_lottery;
    }

    @Override
    public LotteryContact.LPresenter createPresenter() {
        return new LotteryPresenter();
    }

    @Override
    public LotteryContact.LView createView() {
        return this;
    }

    @Override
    public void init() {
        mRv = findViewById(R.id.lotterytype);
        mRv.setLayoutManager(new LinearLayoutManager(LotteryActivity.this));
        mAdapter = new LotteryTypeAdapter(LotteryActivity.this);
        mRv.setAdapter(mAdapter);
        getPresenter().getLotteryType();


    }

    @Override
    public void getLotteryType(List<LotteryTypeBean.ResultBean> typeList) {
        mAdapter.mTypeList.addAll(typeList);
        mAdapter.notifyDataSetChanged();
    }
}
