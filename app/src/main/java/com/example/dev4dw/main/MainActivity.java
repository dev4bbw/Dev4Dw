package com.example.dev4dw.main;


import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apublic.base.BaseFragment;
import com.example.dev4dw.R;
import com.example.apublic.base.BaseMvpActivity;
import com.example.dev4dw.databinding.ActivityMainBinding;
import com.example.dev4dw.main.common.CommonFragment;
import com.example.dev4dw.main.home.HomeFragment;
import com.example.dev4dw.main.personal.PersonalFragment;
import com.example.apublic.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMvpActivity<MainContact.IView, MainContact.IPresenter> implements MainContact.IView {
    private FragmentTransaction ft;
    private FragmentManager mFragmentManager;

    ActivityMainBinding mainBinding;
    private HomeFragment homeFragment;
    private CommonFragment commonFragment;
    private PersonalFragment personalFragment;
    List<BaseFragment> listFragments = new ArrayList<>();

    @Override
    public void initBinding() {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
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
        StatusBarUtil.setStatusBarColor(this,R.color.black);
        initListener();
        initFragment();

        mainBinding.main.setChecked(true);
        showFragment(0);
    }

    private void showFragment(int showType) {
        if (null == mFragmentManager) {
            mFragmentManager = getSupportFragmentManager();
        }
        ft = mFragmentManager.beginTransaction();
        ft.isAddToBackStackAllowed();
        BaseFragment fragment = null;
        for (int x = 0; x < listFragments.size(); x++) {
            fragment = listFragments.get(x);
            if (x == showType) {
                if (!listFragments.get(x).isAdded()) {
                    ft.add(R.id.container, fragment);
                }
                ft.show(fragment);
            } else {
                if (listFragments.get(x).isAdded()) {
                    ft.hide(fragment);
                }
            }
        }
        //commitAllowingStateLoss页面还未可见时能正常切换Fragment
        ft.commitAllowingStateLoss();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        listFragments.add(homeFragment);
    }

    private void initListener() {
        mainBinding.bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main:
                       showFragment(0);
                        break;
                    case R.id.common:
                        showFragment(1);
                        break;
                    case R.id.personal:
                        showFragment(2);
                        break;
                }
            }
        });
    }

}
