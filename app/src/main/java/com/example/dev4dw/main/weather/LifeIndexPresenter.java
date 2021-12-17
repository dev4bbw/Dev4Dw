package com.example.dev4dw.main.weather;

import com.example.apublic.api.ApiModel;
import com.example.apublic.base.BaseFragment;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.SchedulerTransformer;

public class LifeIndexPresenter extends BasePresenter<LifeIndexFragment> {
    public void getLifeIndex(String city){
        compositeSubscription.add(ApiModel.getInstance().getLifeIndex(city)
                .compose(new SchedulerTransformer<>(mView.getActivity()))
                .subscribe(entity -> {
                    mView.getLifeIndexSuccess(entity);
                },ex->{}));
    }
}
