package com.example.dev4dw.main.weather;

import android.view.View;

import com.example.apublic.base.BaseFragment;
import com.example.apublic.bean.LifeIndexBean;
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

    public void setCity(String city){
        mPresenter.getLifeIndex(city);
    }

    public void getLifeIndexSuccess(LifeIndexBean entity) {
        mBinding.acV.setText(entity.getResult().getLife().getKongtiao().getV());
        mBinding.acD.setText(entity.getResult().getLife().getKongtiao().getDes());
        mBinding.allergyV.setText(entity.getResult().getLife().getGuomin().getV());
        mBinding.allergyD.setText(entity.getResult().getLife().getGuomin().getDes());
        mBinding.comfortD.setText(entity.getResult().getLife().getShushidu().getV());
        mBinding.comfortV.setText(entity.getResult().getLife().getShushidu().getDes());
        mBinding.dressV.setText(entity.getResult().getLife().getChuanyi().getV());
        mBinding.dressD.setText(entity.getResult().getLife().getChuanyi().getDes());
        mBinding.fishV.setText(entity.getResult().getLife().getDiaoyu().getV());
        mBinding.fishD.setText(entity.getResult().getLife().getDiaoyu().getDes());
        mBinding.coldV.setText(entity.getResult().getLife().getGanmao().getV());
        mBinding.coldD.setText(entity.getResult().getLife().getGanmao().getDes());
        mBinding.raysV.setText(entity.getResult().getLife().getZiwaixian().getV());
        mBinding.raysD.setText(entity.getResult().getLife().getZiwaixian().getDes());
        mBinding.washV.setText(entity.getResult().getLife().getXiche().getV());
        mBinding.washD.setText(entity.getResult().getLife().getXiche().getDes());
        mBinding.sportV.setText(entity.getResult().getLife().getYundong().getV());
        mBinding.sportD.setText(entity.getResult().getLife().getYundong().getDes());
        mBinding.umbrellaV.setText(entity.getResult().getLife().getDaisan().getV());
        mBinding.umbrellaD.setText(entity.getResult().getLife().getDaisan().getDes());
    }
}
