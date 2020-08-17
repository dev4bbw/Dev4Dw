package com.example.dev4dw.main.demo.lottery;

import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dev4dw.R;
import com.example.dev4dw.adapter.lottery.LotteryTypeAdapter;
import com.example.dev4dw.base.BaseMvpActivity;
import com.example.dev4dw.bean.lottery.LotteryTypeBean;
import com.example.dev4dw.http.ApiService;
import com.example.dev4dw.main.demo.lottery.bonus.LotteryBonusFragment;
import com.example.dev4dw.main.demo.lottery.query.LotteryQueryFragment;
import com.example.dev4dw.main.demo.lottery.type.LotteryTypeFragment;

import java.util.List;

public class LotteryActivity extends BaseMvpActivity<LotteryContact.LView, LotteryContact.LPresenter> implements LotteryContact.LView {
    //支持彩种接口
    //开奖结果查询
    //历史开奖结果查询
    //中奖计算器
    RadioGroup mGroup;
    RadioButton mTypeRB;
    FragmentManager fm;
    LotteryTypeFragment mTyepFragment;
    LotteryQueryFragment mQueryFragment;
    LotteryBonusFragment mBonusFragment;
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
        fm=getSupportFragmentManager();
        mGroup = findViewById(R.id.bottom);
        mTypeRB = findViewById(R.id.type);

        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft  = fm.beginTransaction();
                hideAllFragment(ft);
                switch (checkedId){
                    case R.id.query:
                        if (mQueryFragment ==null){
                            mQueryFragment = new LotteryQueryFragment();
                            ft.add(R.id.container,mQueryFragment);
                        }else {
                            ft.show(mQueryFragment);
                        }
                        break;
                    case R.id.type:
                        if (mTyepFragment ==null){
                            mTyepFragment = new LotteryTypeFragment();
                            ft.add(R.id.container,mTyepFragment);
                        }else {
                            ft.show(mTyepFragment);
                        }
                        break;
                    case R.id.bonus:
                        if (mBonusFragment ==null){
                            mBonusFragment = new LotteryBonusFragment();
                            ft.add(R.id.container,mBonusFragment);
                        }else {
                            ft.show(mBonusFragment);
                        }
                        break;
                }
                ft.commit();
            }
        });
        mTypeRB.setChecked(true);
    }
    private void hideAllFragment(FragmentTransaction ft){
        if (mBonusFragment!=null){
            ft.hide(mBonusFragment);
        }
        if (mTyepFragment != null) {
            ft.hide(mTyepFragment);
        }
        if (mQueryFragment!=null){
            ft.hide(mQueryFragment);
        }
    }

}
