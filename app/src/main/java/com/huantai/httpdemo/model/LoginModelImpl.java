package com.huantai.httpdemo.model;


import com.huantai.httpdemo.bean.HttpResult;
import com.huantai.httpdemo.bean.User;
import com.huantai.httpdemo.net.Api;
import com.huantai.httpdemo.net.RetrofitManager;
import com.huantai.httpdemo.contract.LoginContract;

import io.reactivex.Observable;

public class LoginModelImpl implements LoginContract.pLoginModel {
    @Override
    public Observable<HttpResult<User>> pLogin(String name,String psw) {
        Api rx_retrofit = RetrofitManager.getInstanceManager().getRetrofit().create(Api.class);
        return rx_retrofit.postLogin(name,psw);
    }
}
