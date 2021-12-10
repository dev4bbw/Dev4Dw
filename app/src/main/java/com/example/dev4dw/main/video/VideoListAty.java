package com.example.dev4dw.main.video;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.bean.VideoBean;
import com.example.apublic.utils.DisplayUtil;
import com.example.apublic.utils.glide.GlideUtils;
import com.example.apublic.utils.recyclerview.SpaceItemDecoration;
import com.example.dev4dw.adapter.VideoAdapter;
import com.example.dev4dw.adapter.VideoListAdapter;
import com.example.dev4dw.databinding.AtyVideoListBinding;

public class VideoListAty extends BaseMvpActivity<VideoListAty, VideoListPresenter> {
    private AtyVideoListBinding mBinding;
    private VideoBean.ResultBean vBean;
    private VideoListAdapter mAdapter;
    @Override
    public VideoListPresenter createPresenter() {
        return new VideoListPresenter();
    }

    @Override
    public VideoListAty createView() {
        return this;
    }

    @Override
    public void initBinding() {
        mBinding = AtyVideoListBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        vBean = (VideoBean.ResultBean) intent.getSerializableExtra("VIDEO_BEAN");
        if (vBean == null) finish();

        mBinding.head.setTitle(vBean.getNickname());
        GlideUtils.loadImg(vBean.getAvatar(),mBinding.avatar);

        StaggeredGridLayoutManager sg = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mBinding.rv.setLayoutManager(sg);
        mAdapter = new VideoListAdapter(this);
        mBinding.rv.setAdapter(mAdapter);

        mAdapter.setData(vBean.getVideo_list());
    }
}
