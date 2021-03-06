package com.example.dev4dw.main.javaPage;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;
import com.example.dev4dw.bean.MyBean;

import java.util.List;

public interface JavaContact {
    interface JView extends BaseView{

    }
    abstract class JPresenter extends BasePresenter<JView>{
        public abstract List<MyBean> getData();

    }
    abstract class JModel extends BaseModel{
        public abstract List<MyBean> loadData();
    }
}
