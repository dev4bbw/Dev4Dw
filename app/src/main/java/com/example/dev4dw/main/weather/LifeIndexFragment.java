package com.example.dev4dw.main.weather;

import android.view.View;

import com.example.apublic.base.BaseFragment;
import com.example.dev4dw.databinding.FragmentLifeindexBinding;

public class LifeIndexFragment extends BaseFragment<LifeIndexFragment,LifeIndexPresenter> {
    FragmentLifeindexBinding mBinding;
    @Override
    public LifeIndexPresenter createPresenter() {
        return new LifeIndexPresenter();
    }

    @Override
    public LifeIndexFragment createView() {
        return this;
    }

    @Override
    public View bindingView() {
        mBinding = FragmentLifeindexBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    public void init(View view) {

    }

    public void setCity(String city){}
}
