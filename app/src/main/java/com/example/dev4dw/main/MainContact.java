package com.example.dev4dw.main;


import com.example.dev4dw.base.BasePresenter;
import com.example.dev4dw.base.BaseView;

public interface MainContact {
    interface IView extends BaseView {

    }
    abstract class IPresenter extends BasePresenter<IView>{

    }
    abstract class IModel{
        public abstract void login();
    }
}
