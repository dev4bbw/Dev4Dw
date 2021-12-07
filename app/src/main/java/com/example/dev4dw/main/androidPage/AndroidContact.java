package com.example.dev4dw.main.androidPage;

import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;
import com.example.apublic.bean.MyBean;

import java.util.List;

public interface AndroidContact {
     interface AView extends BaseView{

    }
    abstract class APresenter extends BasePresenter<AView>{
        public abstract List<MyBean> getData();

    }
}
