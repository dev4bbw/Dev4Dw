package com.example.dev4dw.main.demo;

import com.example.dev4dw.base.BaseModel;
import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;

public interface DemoContact {
    interface DView extends BaseView{

    }
    abstract class DPresenter extends BasePresenter<DView>{

    }
    abstract  class DModel extends BaseModel{

    }
}
