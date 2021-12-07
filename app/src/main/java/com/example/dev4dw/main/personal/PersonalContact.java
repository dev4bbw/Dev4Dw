package com.example.dev4dw.main.personal;

import com.example.apublic.base.BaseModel;
import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;

public interface PersonalContact {
    interface JView extends BaseView{

    }
    abstract class JPresenter extends BasePresenter<JView>{

    }
}
