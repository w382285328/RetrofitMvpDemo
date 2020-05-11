package com.huantai.httpdemo.net;

import com.huantai.httpdemo.bean.HttpResult;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiDemo {




    String pp = "abic";
    /**
     * get请求
     * @param path
     * @return
     */
    @GET("{path}/user/info")//地址baseurl+这里配置的
    Call<HttpResult> getBook(@Path("path") String path, @Query("PP") String sr);//定义方法 返回book

    @GET("/user/info")//地址baseurl+这里配置的
    Call<HttpResult> getBookList(@Query("IP") String IP, @Query("str") String str);//IP 表单参数
    Call<HttpResult> getBookList(@QueryMap Map<String,String> map );//多个参数

    /**
     * post清求
     */
    //表单请求
    @FormUrlEncoded
    @POST(pp)
    Call<HttpResult> post(@Field("ip") String f, @Field("ip2") String f2);

    //json请求
    @POST("/getceshi/")
    Call<HttpResult> post(@Body String ip);

    //文件
    @Multipart
    @POST("/getceshi/")
    Call<HttpResult> post(@Part MultipartBody.Part file);


}
