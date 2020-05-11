package com.huantai.httpdemo.mvp_base;

public interface Ipresenter<V extends BaseView> {
     void attch(V view);
     void detach();

}
