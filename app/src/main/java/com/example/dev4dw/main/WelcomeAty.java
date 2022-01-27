package com.example.dev4dw.main;

import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;
import com.example.apublic.utils.StatusBarUtil;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.AtyWelcomeBinding;

import butterknife.ButterKnife;

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
        ButterKnife.bind(this);

        initAnimation(atyWelcomeBinding.touch);
        atyWelcomeBinding.touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadingView();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadingView();
                        toActivity(MainActivity.class);
                        WelcomeAty.this.finish();
                    }
                }, 500);
            }
        });
    }

    private void initAnimation(View view) {
        if(null == view){
            return;
        }
        Animation alphaAnimation = new AlphaAnimation(1,0.1f);
        alphaAnimation.setDuration(600);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(alphaAnimation);
    }
}
