package com.example.dev4dw.main.home;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.apublic.base.BaseFragment;
import com.example.apublic.base.BaseFragmentPageAdapter;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.FragmentHomeBinding;
import com.example.dev4dw.main.home.news.NewsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends BaseFragment<HomeFragment, HomePresenter> {
    FragmentHomeBinding homeBinding;

    @Override
    public View bindingView() {
        homeBinding = FragmentHomeBinding.inflate(getLayoutInflater());
        return homeBinding.getRoot();
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public HomeFragment createView() {
        return this;
    }


    @Override
    public void init(View view) {
//        String[] tab = getResources().getStringArray(R.array.main_news);
        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("推荐");
        tabList.add("国内");
        tabList.add("国际");

        List<BaseFragment> fragments = new ArrayList<>();
        //支持类型top(推荐,默认)guonei(国内)guoji(国际)yule(娱乐)tiyu(体育)junshi(军事)keji(科技)caijing(财经)
        // shishang(时尚)youxi(游戏)qiche(汽车)jiankang(健康)
        fragments.add(new NewsFragment("top"));
        fragments.add(new NewsFragment("guonei"));
        fragments.add(new NewsFragment("guoji"));
//        fragments.add(new NewsFragment("yule"));
//        fragments.add(new NewsFragment("tiyu"));
//        fragments.add(new NewsFragment("junshi"));
//        fragments.add(new NewsFragment("keji"));
//        fragments.add(new NewsFragment("caijing"));
//        fragments.add(new NewsFragment("shishang"));
//        fragments.add(new NewsFragment("youxi"));
//        fragments.add(new NewsFragment("qiche"));
//        fragments.add(new NewsFragment("jiankang"));

        BaseFragmentPageAdapter vpAdapter =
                new BaseFragmentPageAdapter(getActivity().getSupportFragmentManager(),
                        tabList, fragments);
        homeBinding.vp.setAdapter(vpAdapter);
        homeBinding.tabLayout.setupWithMyViewPager(homeBinding.vp,tabList);
        homeBinding.vp.setOffscreenPageLimit(3);
    }

    @Override
    public void initData() {
        super.initData();
        
    }
}
