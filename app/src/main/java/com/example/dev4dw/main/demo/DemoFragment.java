package com.example.dev4dw.main.demo;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.dev4dw.R;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.main.demo.lottery.LotteryActivity;

public class DemoFragment extends BaseFragment<DemoContact.DView, DemoContact.DPresenter> implements DemoContact.DView {
    @Override
    public int getLayoutID() {
        return R.layout.fragment_demo;
    }

    @Override
    public DemoContact.DPresenter createPresenter() {
        return new DemoPresenter();
    }

    @Override
    public DemoContact.DView createView() {
        return this;
    }

    @Override
    public void init(View view) {
        TextView tv = view.findViewById(R.id.lottery);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() ==null)return;
                startActivity(new Intent(getActivity().getApplicationContext(), LotteryActivity.class));
            }
        });
    }
}
