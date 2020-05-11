package com.huantai.httpdemo.presenter;

import com.huantai.httpdemo.bean.HttpResult;
import com.huantai.httpdemo.bean.User;
import com.huantai.httpdemo.contract.LoginContract;
import com.huantai.httpdemo.model.LoginModelImpl;
import com.huantai.httpdemo.mvp_base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPersonterImpl extends BasePresenter<LoginContract.View> implements LoginContract.ILoginPresenter {
    private LoginContract.pLoginModel model;
    private LoginContract.View view;

    public LoginPersonterImpl(LoginContract.View view) {
        model = new LoginModelImpl();
        this.view = view;
    }

    @Override
    public void login(String name, String psw) {
        view.lbefore();
        Observable<HttpResult<User>> observable = model.pLogin(name, psw);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HttpResult<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HttpResult<User> userHttpResult) {
                        view.loginSuccess(userHttpResult);
                        view.lafter();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {


                    }
                });

    }

}
