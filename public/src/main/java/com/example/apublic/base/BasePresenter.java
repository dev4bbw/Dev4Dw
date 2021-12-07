package com.example.apublic.base;

import rx.subscriptions.CompositeSubscription;

public class BasePresenter<V> {
    public V mView;
    protected CompositeSubscription compositeSubscription;

    public BasePresenter() {
        compositeSubscription = new CompositeSubscription();
    }

    public V getView() {
        return mView;
    }

    public void attachView(V v) {
        mView = v;
    }

    public void detachView() {
        if (compositeSubscription != null)
            compositeSubscription.unsubscribe();
        mView = null;
    }
}
