package com.example.dev4dw.main.home.news;

import com.example.apublic.api.ApiModel;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.SchedulerTransformer;

public class NewsPresenter extends BasePresenter<NewsFragment> {


    void getNews(String type,String page) {
        compositeSubscription.add(ApiModel.getInstance()
                .getNews(type,page)
                .compose(new SchedulerTransformer<>(mView.getActivity()))
                .subscribe(entity -> {
                    mView.getNewsSuccess(entity);
                }, ex ->{

                }));
    }
}
