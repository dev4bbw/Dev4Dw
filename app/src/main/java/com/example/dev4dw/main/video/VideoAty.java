package com.example.dev4dw.main.video;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.bean.VideoBean;
import com.example.apublic.utils.DisplayUtil;
import com.example.apublic.utils.recyclerview.SpaceItemDecoration;
import com.example.dev4dw.adapter.NewsAdapter;
import com.example.dev4dw.adapter.VideoAdapter;
import com.example.dev4dw.databinding.AtyVideoBinding;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

public class VideoAty extends BaseMvpActivity<VideoAty,VideoPresenter> {
    AtyVideoBinding videoBinding;
    private VideoAdapter mAdapter;
    @Override
    public VideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public VideoAty createView() {
        return this;
    }

    @Override
    public void initBinding() {
        videoBinding = AtyVideoBinding.inflate(getLayoutInflater());
        setContentView(videoBinding.getRoot());
    }


    @Override
    public void init() {
        initRv();
        initRefresh();
        mPresenter.getVideo();
    }

    private void initRefresh() {
        videoBinding.refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                videoBinding.refresh.finishRefresh(500);
            }
        });
    }

    private void initRv() {
        StaggeredGridLayoutManager sg = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        videoBinding.rv.setLayoutManager(sg);
        mAdapter = new VideoAdapter(this);
        videoBinding.rv.setAdapter(mAdapter);
    }

    public void getVideoSuccess(VideoBean bean) {
        if (bean!=null){
            mAdapter.setData(bean.getResult());
        }
    }
}
