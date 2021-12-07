package com.example.dev4dw.main.common;

import android.view.View;

import com.example.apublic.base.BaseFragment;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;

public class CommonFragment extends BaseFragment<CommonContact.JView,CommonContact.JPresenter> implements CommonContact.JView {

    @Override
    public View bindingView() {
        return null;
    }

    @Override
    public CommonContact.JPresenter createPresenter() {
        return null;
    }

    @Override
    public CommonContact.JView createView() {
        return null;
    }


    @Override
    public void init(View view) {

    }
}
