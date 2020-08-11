package com.example.dev4dw.main.demo;

import android.view.View;

import com.example.dev4dw.R;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;

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

    }
}
