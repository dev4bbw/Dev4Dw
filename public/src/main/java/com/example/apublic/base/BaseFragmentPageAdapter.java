package com.example.apublic.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class BaseFragmentPageAdapter extends FragmentPagerAdapter {
    public FragmentManager mFragmentManager;
    private List<String> tabs;//页面
    private List<BaseFragment> fragments; //显示页面的Fragment

    public BaseFragmentPageAdapter(@NonNull FragmentManager fm, @Nullable List<String> tabs, @Nullable List<BaseFragment> fragments){
        super(fm);
        this.mFragmentManager = fm;
        this.tabs = tabs;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        //Log.e(TAG, "-----getItemPosition-----");
        return super.getItemPosition(object);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
