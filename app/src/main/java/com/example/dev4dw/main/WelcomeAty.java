package com.example.dev4dw.main;

import android.os.Handler;

import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;
import com.example.apublic.utils.StatusBarUtil;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.AtyWelcomeBinding;

public class WelcomeAty extends BaseMvpActivity {
    AtyWelcomeBinding atyWelcomeBinding;
    Handler handler = new Handler();

    @Override
    public void initBinding() {
        atyWelcomeBinding = AtyWelcomeBinding.inflate(getLayoutInflater());
        setContentView(atyWelcomeBinding.getRoot());
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
    public void init() {
        StatusBarUtil.setStatusBarColor(this, R.color.black);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toActivity(MainActivity.class);
                WelcomeAty.this.finish();
            }
        }, 1000);
    }
}
