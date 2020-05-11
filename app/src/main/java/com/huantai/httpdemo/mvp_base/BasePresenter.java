package com.huantai.httpdemo.mvp_base;

public class BasePresenter<V extends BaseView> implements Ipresenter<V> {
    public V view;
    public void attch(V view){//绑定view
        this.view = view;
    }
    public void detach(){//当界面销毁时 消除view持有 防止内存泄漏
        this.view = null;
    }
}
