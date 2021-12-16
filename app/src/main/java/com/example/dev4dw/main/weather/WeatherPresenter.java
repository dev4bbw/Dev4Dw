package com.example.dev4dw.main.weather;

import com.example.apublic.api.ApiModel;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.SchedulerTransformer;

public class WeatherPresenter extends BasePresenter<WeatherAty> {
    public void getWeatherCity(){
        compositeSubscription.add(ApiModel.getInstance().getWeatherCity()
                .compose(new SchedulerTransformer<>(mView))
                .subscribe(entity ->{
                    mView.getCitySuccess(entity);
                },ex ->{

                }));
    }
}
