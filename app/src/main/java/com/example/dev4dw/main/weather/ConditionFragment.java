package com.example.dev4dw.main.weather;

import android.content.res.AssetManager;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.apublic.base.BaseApp;
import com.example.apublic.base.BaseFragment;
import com.example.apublic.bean.WeatherCity;
import com.example.apublic.utils.JsonUtils;
import com.example.dev4dw.databinding.FragmentConditionBinding;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConditionFragment extends BaseFragment<ConditionFragment,ConditionPresenter> {
    FragmentConditionBinding mBinding;
    private String mCity;

    @Override
    public ConditionPresenter createPresenter() {
        return new ConditionPresenter();
    }

    @Override
    public ConditionFragment createView() {
        return this;
    }

    @Override
    public View bindingView() {
        mBinding = FragmentConditionBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }


    @Override
    public void init(View view) {

    }

    public void setCity(String city){
        mCity = city;
    }



}
