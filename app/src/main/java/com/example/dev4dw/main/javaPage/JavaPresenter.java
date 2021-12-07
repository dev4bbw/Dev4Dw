package com.example.dev4dw.main.javaPage;

import com.example.apublic.bean.MyBean;

import java.util.List;

public class JavaPresenter extends JavaContact.JPresenter {
    private JavaModel model;

    JavaPresenter() {
        model = new JavaModel();
    }

    @Override
    public List<MyBean> getData() {
        return model.loadData();
    }
}
