package com.example.dev4dw.main.weather;

import com.example.apublic.api.ApiModel;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.SchedulerTransformer;

public class ConditionPresenter extends BasePresenter<ConditionFragment> {

    public void getWeather(String city){
        compositeSubscription.add(ApiModel.getInstance().getWeather(city)
                .compose(new SchedulerTransformer<>(mView.getActivity()))
                .subscribe(entity ->{
                    mView.getWeatherSuccess(entity);
                },ex ->{

                }));
    }


}
