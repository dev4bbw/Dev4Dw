package com.example.apublic.base;


import android.content.Context;
import android.content.Intent;

import com.example.apublic.bean.BaseJHBean;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SchedulerTransformer<T extends BaseJHBean> implements Observable.Transformer<T, T> {
    private Context context;
    public SchedulerTransformer(Context context) {
        if (context == null) {
            this.context = BaseApp.getInstance();
        } else {
            this.context = context.getApplicationContext();
        }
    }
    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(t -> {

                    return t;
                });
    }
}
