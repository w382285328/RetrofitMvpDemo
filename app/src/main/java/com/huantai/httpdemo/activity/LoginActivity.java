package com.huantai.httpdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.huantai.httpdemo.R;
import com.huantai.httpdemo.bean.HttpResult;
import com.huantai.httpdemo.bean.User;
import com.huantai.httpdemo.mvp_base.BaseAcivity;
import com.huantai.httpdemo.net.RetrofitManager;
import com.huantai.httpdemo.presenter.LoginPersonterImpl;
import com.huantai.httpdemo.contract.LoginContract;

public class LoginActivity extends BaseAcivity<LoginPersonterImpl> implements LoginContract.View {

    LoginPersonterImpl ploginPersonter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RetrofitManager.getInstanceManager().init();
        setContentView(R.layout.activity_main2);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ploginPersonter.login("user","psw");
            }
        });

    }

    @Override
    public LoginPersonterImpl getPresenter() {
        return ploginPersonter = new LoginPersonterImpl(this);
    }
    @Override
    public void lbefore() {
        //登录前
    }
    @Override
    public void lafter() {
        //登录后要关闭的
    }
    @Override
    public void loginSuccess(HttpResult<User> result) {
        Toast.makeText(LoginActivity.this, result.getErrmsg()+"", Toast.LENGTH_LONG).show();
    }
}
