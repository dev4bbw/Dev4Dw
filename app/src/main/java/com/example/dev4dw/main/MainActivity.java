package com.example.dev4dw.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dev4dw.R;
import com.example.dev4dw.base.BaseMvpActivity;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;

public class MainActivity extends BaseMvpActivity<MainContact.IView, MainPresenter> implements MainContact.IView {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public MainContact.IView createView() {
        return this;
    }

    @Override
    public void init() {

    }
}
