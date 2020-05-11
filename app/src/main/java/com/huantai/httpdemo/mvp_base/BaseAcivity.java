package com.huantai.httpdemo.mvp_base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseAcivity<T extends BasePresenter> extends Activity implements BaseView{
    public T presenter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attch(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detach();
        }

    }

    public abstract T getPresenter();
}
