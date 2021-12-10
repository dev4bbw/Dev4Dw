package com.example.dev4dw.main.video;

import android.Manifest;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;

import com.example.apublic.base.BaseMvpActivity;
import com.example.apublic.utils.DownloadManager;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.AtyVideoPlayBinding;


import cn.jzvd.Jzvd;


public class VideoPlayAty extends BaseMvpActivity<VideoPlayAty, VideoPlayPresenter> {
    AtyVideoPlayBinding mBinding;


    @Override
    public VideoPlayPresenter createPresenter() {
        return new VideoPlayPresenter();
    }

    @Override
    public VideoPlayAty createView() {
        return this;
    }

    @Override
    public void initBinding() {
        mBinding = AtyVideoPlayBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    public void init() {

        Intent intent = getIntent();
//        String url = intent.getStringExtra("VIDEO_URL");
//        String url = "http://rbv01.ku6.com/omtSn0z_PTREtneb3GRtGg.mp4"；
        String url = "http://rbv01.ku6.com/7lut5JlEO-v6a8K3X9xBNg.mp4";
//        String url = "https://github.com/ljpww72729/ad-img/blob/master/page/shinto.mp4?raw=true";
        checkPermission(() -> hasPermission(url), R.string.permission_storage,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        mBinding.play.posterImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
    }

    private void hasPermission(String url){
        DownloadManager.getInstance().downloadFile(url, new DownloadManager.DownloadCallBackListener() {
            @Override
            public void onDownloadCallBackListener(boolean success, boolean exist,String result) {
                if (success){
                    VideoPlayAty.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBinding.play.setUp(result
                                    , "DOWNLOAD");
                        }
                    });
                }else if (exist){
                    mBinding.play.setUp(result
                            , "LOCAL");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
