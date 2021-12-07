package com.example.dev4dw.main.androidPage;

import com.example.apublic.bean.MyBean;

import java.util.List;

public class AndroidPresenter extends AndroidContact.APresenter {
    private AndroidModel model;
    AndroidPresenter(){
        model = new AndroidModel();
    }
    @Override
    public List<MyBean> getData() {
        return model.loadData();
    }
}
