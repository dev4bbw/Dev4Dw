package com.example.dev4dw.main.javaPage;

import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;
import com.example.apublic.bean.MyBean;

import java.util.List;

public interface JavaContact {
    interface JView extends BaseView{

    }
    abstract class JPresenter extends BasePresenter<JView>{
        public abstract List<MyBean> getData();

    }
}
