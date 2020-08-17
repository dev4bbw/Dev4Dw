package com.example.dev4dw.main.demo.lottery.type;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.lottery.LotteryTypeAdapter;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.main.demo.lottery.LotteryActivity;

import java.util.List;

public class LotteryTypeFragment extends BaseFragment<LotteryTypeContact.TView, LotteryTypeContact.TPresenter> implements LotteryTypeContact.TView {
    private LotteryTypeAdapter mAdapter;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_lottery_type;
    }

    @Override
    public LotteryTypeContact.TPresenter createPresenter() {
        return new LotteryTypePresenter();
    }

    @Override
    public LotteryTypeContact.TView createView() {
        return this;
    }

    @Override
    public void init(View view) {
        RecyclerView mRv = view.findViewById(R.id.lotterytype);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new LotteryTypeAdapter(getContext());
        mRv.setAdapter(mAdapter);
        getPresenter().getLotteryType();

    }
    @Override
    public void getLotteryTypeResult(List<LotteryTypeBean.ResultBean> typeList) {
        mAdapter.mTypeList.addAll(typeList);
        mAdapter.notifyDataSetChanged();
    }
}
