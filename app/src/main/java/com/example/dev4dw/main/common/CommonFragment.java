package com.example.dev4dw.main.common;

import android.content.Intent;
import android.view.View;

import com.example.apublic.base.BaseFragment;
import com.example.apublic.utils.ToastUtil;
import com.example.dev4dw.R;
import com.example.dev4dw.databinding.FragmentCommonBinding;
import com.example.dev4dw.main.video.VideoAty;
import com.example.dev4dw.main.weather.WeatherAty;

import butterknife.OnClick;

public class CommonFragment extends BaseFragment<CommonFragment,CommonPresenter>{
    FragmentCommonBinding commonBinding;
    @Override
    public View bindingView() {
        commonBinding = FragmentCommonBinding.inflate(getLayoutInflater());
        return commonBinding.getRoot();
    }

    @Override
    public CommonPresenter createPresenter() {
        return new CommonPresenter();
    }

    @Override
    public CommonFragment createView() {
        return this;
    }


    @Override
    public void init(View view) {
    }

    @OnClick({R.id.video,R.id.weather,R.id.football,R.id.lottery})
    void onClick(View v){
        switch (v.getId()){
            case R.id.video:
                getActivity().startActivity(new Intent(getContext(),VideoAty.class));
                break;
            case R.id.weather:
                getActivity().startActivity(new Intent(getContext(), WeatherAty.class));
                break;
            case R.id.football:
            case R.id.lottery:
                ToastUtil.get().showToast(getContext(),"Developing");
                break;

        }
    }
}
