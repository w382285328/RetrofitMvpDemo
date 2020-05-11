package com.huantai.httpdemo.net;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static final String baseUrl = "http://114.116.50.132:8091/api/";
    private static RetrofitManager instanceManager;
    private static Retrofit retrofit,retrofit2;
     public static RetrofitManager getInstanceManager(){
        if(null == instanceManager){
            synchronized (RetrofitManager.class){
                if(null == instanceManager){
                    instanceManager = new RetrofitManager();
                }
            }
        }
        return instanceManager;
    }
    public static void init(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(30000, TimeUnit.MILLISECONDS);
        builder.cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/RxJavaDemo"),1024*1024*10));
        addInterceptor(builder);

        OkHttpClient okHttpClient = builder.build();

        //使用该OkHttpClient创建一个Retrofit对象
        retrofit = new Retrofit.Builder()
                //添加Gson数据格式转换器支持
                .addConverterFactory(GsonConverterFactory.create())
                //添加RxJava语言支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //指定网络请求client
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();
        /**
         * 多个URL存在时
         */
        retrofit2 = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //支持RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }
    /**
     * 添加各种拦截器
     * @param builder
     */
    private static void addInterceptor(OkHttpClient.Builder builder) {
        // 添加日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("ceshi",message+"");
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        HttpHeaderInterceptor httpHeaderInterceptor = new HttpHeaderInterceptor.Builder().build();
        //日志拦截
        builder.addInterceptor(loggingInterceptor);
        //头部参数拦截
//        builder.addInterceptor(httpHeaderInterceptor);
//        //缓存拦截
//        builder.addInterceptor(new HttpCacheInterceptor());
//        //请求参数拦截
//        builder.addInterceptor(new CommonParamsInterceptor());
    }
    public Retrofit getRetrofit() {
        if(retrofit == null) {
            throw  new IllegalStateException("Retrofit instance hasn't init!");
        }
        return retrofit;
    }
}
