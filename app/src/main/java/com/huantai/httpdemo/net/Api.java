package com.huantai.httpdemo.net;

import com.huantai.httpdemo.bean.HttpResult;
import com.huantai.httpdemo.bean.AppInfo;
import com.huantai.httpdemo.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("Home/GetAppVer?type=0")
    Observable<HttpResult<AppInfo>> getBook();

    @FormUrlEncoded
    @POST("Home/UserLogin")
    Observable<HttpResult<User>> postLogin(@Field("LoginUser") String f, @Field("Password") String f2);


}
