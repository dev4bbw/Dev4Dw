package com.example.dev4dw.main.javaPage;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;

public interface JavaContact {
    interface JView extends BaseView{

    }
    abstract class JPresenter extends BasePresenter<JView>{

    }
    abstract class JModel extends BaseModel{

    }
}
