package com.example.dev4dw.main.home.news;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apublic.base.BaseFragment;
import com.example.apublic.bean.home.NewsBean;
import com.example.apublic.utils.DisplayUtil;
import com.example.apublic.utils.recyclerview.SpaceItemDecoration;
import com.example.dev4dw.adapter.NewsAdapter;
import com.example.dev4dw.databinding.FragmentNewsBinding;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.jetbrains.annotations.NotNull;

public class NewsFragment extends BaseFragment<NewsFragment,NewsPresenter>{
    private String newsType;
    private NewsAdapter mAdapter;
    public NewsFragment(String type){
        newsType = type;
    }

    FragmentNewsBinding newsBinding;
    @Override
    public View bindingView() {
        newsBinding = FragmentNewsBinding.inflate(getLayoutInflater());
        return newsBinding.getRoot();
    }

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter();
    }

    @Override
    public NewsFragment createView() {
        return this;
    }

    @Override
    public void init(View view) {
        initRv();
        initRefresh();
    }

    private void initRefresh() {
        newsBinding.refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                newsBinding.refresh.finishRefresh(500);
            }
        });
    }

    private void initRv() {
        newsBinding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsBinding.rv.addItemDecoration(new SpaceItemDecoration(DisplayUtil.dp2px(getActivity(),10)));
        mAdapter = new NewsAdapter(getActivity());
        newsBinding.rv.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.getNews(newsType,"");
    }

    public void getNewsSuccess(NewsBean bean) {
        if (bean!=null){
            mAdapter.setData(bean.getResult().getData());
        }
    }
}
