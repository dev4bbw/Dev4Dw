package com.example.dev4dw.main.androidPage;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.MyBean;

import java.util.List;

public interface AndroidContact {
     interface AView extends BaseView{

    }
    abstract class APresenter extends BasePresenter<AView>{
        public abstract List<MyBean> getData();

    }
    abstract class AModel extends BaseModel{
        public abstract List<MyBean> loadData();
    }
}
