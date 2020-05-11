package com.huantai.httpdemo.contract;

import com.huantai.httpdemo.bean.HttpResult;
import com.huantai.httpdemo.bean.User;
import com.huantai.httpdemo.mvp_base.BaseView;
import com.huantai.httpdemo.mvp_base.Ipresenter;

import io.reactivex.Observable;

public interface LoginContract {
    /**
     * 更新显示相关
     */
    interface View extends BaseView {
        void loginSuccess(HttpResult<User> result);
    }

    /**
     * 获取数据相关
     */
    interface pLoginModel {

        Observable<HttpResult<User>> pLogin(String name, String psw);
    }

    public interface ILoginPresenter extends Ipresenter<View> {
        /**
         * 登录
         */
        void login(String username, String password);
    }
}
