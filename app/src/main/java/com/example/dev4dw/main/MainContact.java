package com.example.dev4dw.main;


import com.example.apublic.base.BasePresenter;
import com.example.apublic.base.BaseView;

public interface MainContact {
    interface IView extends BaseView {

    }
    abstract class IPresenter extends BasePresenter<IView>{

    }
}
