package com.example.apublic.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends Fragment {
    private V mView;
    public P mPresenter;
    private Context mContext;

    public P getPresenter() {
        return mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = bindingView();
        mContext = getActivity();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mView == null) {
            mView = createView();
        }
        if (mPresenter != null && mView != null) {
            mPresenter.attachView(mView);
        }
        init(view);
        initData();
        return view;
    }

//    public abstract int getLayoutID();

    public abstract View bindingView();

    public abstract P createPresenter();

    public abstract V createView();

    public abstract void init(View view);

    public void initData (){};


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
