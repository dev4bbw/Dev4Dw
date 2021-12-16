package com.example.apublic.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apublic.utils.dialog.ProgressDialogs;

import butterknife.ButterKnife;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends Fragment {
    private V mView;
    public P mPresenter;
    private Context mContext;
    public BaseMvpActivity mActivity;
    protected ProgressDialogs mProgressDialogs;

    public P getPresenter() {
        return mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = bindingView();
        mContext = getActivity();
        mActivity = (BaseMvpActivity) getActivity();
        ButterKnife.bind(this,view);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mView == null) {
            mView = createView();
        }
        if (mPresenter != null && mView != null) {
            mPresenter.attachView(mView);
        }
        mProgressDialogs = new ProgressDialogs(mContext);

        init(view);
        initData();


        return view;
    }

//    public abstract int getLayoutID();



    public abstract P createPresenter();

    public abstract V createView();

    public abstract View bindingView();

    public abstract void init(View view);

    public void initData (){};

    public void showLoadingView() {
        if (mProgressDialogs != null) {
            mProgressDialogs.showDialog();
        }
    }

    public void showLoadingView(String msg) {
        if (mProgressDialogs != null) {
            mProgressDialogs.showDialog(msg);
        }
    }

    public void hideLoadingView() {
        if (mProgressDialogs != null) {
            mProgressDialogs.closeDialog();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mProgressDialogs != null) {
            mProgressDialogs.closeDialog();
            mProgressDialogs = null;
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
