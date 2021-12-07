package com.example.dev4dw.main.common;

import com.example.apublic.base.BaseModel;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;

public interface CommonContact {
    interface JView extends BaseView{

    }
    abstract class JPresenter extends BasePresenter<JView> {

    }
}
