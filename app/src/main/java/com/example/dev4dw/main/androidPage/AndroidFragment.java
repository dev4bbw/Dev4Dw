package com.example.dev4dw.main.androidPage;

import android.view.View;

import com.example.dev4dw.R;
import com.example.dev4dw.base.BaseFragment;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;

public class AndroidFragment extends BaseFragment{
    @Override
    public int getLayoutID() {
        return R.layout.fragment_andorid;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init(View view) {

    }
}
