package com.example.dev4dw.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dev4dw.R;
import com.example.dev4dw.base.BaseMvpActivity;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.main.androidPage.AndroidFragment;
import com.example.dev4dw.main.demo.DemoFragment;
import com.example.dev4dw.main.javaPage.JavaFragment;

public class MainActivity extends BaseMvpActivity<MainContact.IView, MainContact.IPresenter> implements MainContact.IView {
    private Button mBack;
    private TextView mTitle;
    private RadioGroup mGroup;
    private RadioButton mSelectedJv;
    private FragmentManager fm;
    private JavaFragment jvFragment;
    private AndroidFragment adFragment;
    private DemoFragment demoFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainContact.IPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public MainContact.IView createView() {
        return this;
    }

    @Override
    public void init() {
        initWidgetsID();
        fm = getSupportFragmentManager();
        initListener();
        mSelectedJv.setChecked(true);
    }

    private void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft = fm.beginTransaction();
                hideAllFragment(ft);
                switch (checkedId){
                    case R.id.java:
                        if (jvFragment == null) {
                            jvFragment=new JavaFragment();
                            ft.add(R.id.container,jvFragment);
                        }else {
                            ft.show(jvFragment);
                        }
                        mTitle.setText("Java");

                        break;
                    case R.id.android:
                        if (adFragment == null) {
                            adFragment=new AndroidFragment();
                            ft.add(R.id.container,adFragment);
                        }else {
                            ft.show(adFragment);
                        }
                        mTitle.setText("Android");

                        break;
                    case R.id.demo:
                        if ( demoFragment== null) {
                            demoFragment=new DemoFragment();
                            ft.add(R.id.container,demoFragment);
                        }else {
                            ft.show(demoFragment);
                        }
                        mTitle.setText("Demo");
                        break;
                }
                ft.commit();
            }
        });
    }

    private void initWidgetsID(){
        mBack = findViewById(R.id.backKey);
        mTitle = findViewById(R.id.pageTitle);
        mGroup = findViewById(R.id.bottom);
        mSelectedJv = findViewById(R.id.java);
    }
     private void hideAllFragment(FragmentTransaction ft){
        if (jvFragment!=null){
            ft.hide(jvFragment);
        }
        if (adFragment != null) {
            ft.hide(adFragment);
        }
        if (demoFragment!=null){
            ft.hide(demoFragment);
        }
    }
}
