package com.example.dev4dw.main.video;

import com.example.apublic.api.ApiModel;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.SchedulerTransformer;

public class VideoPlayPresenter extends BasePresenter<VideoPlayAty> {

    public void getVideo(){
        compositeSubscription.add(ApiModel.getInstance()
                .getVideo()
                .compose(new SchedulerTransformer<>(mView))
                .subscribe(entity -> {
                }, ex ->{

                }));
    }
}
