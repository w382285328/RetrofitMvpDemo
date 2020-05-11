package com.huantai.httpdemo.bean;


import com.google.gson.annotations.SerializedName;

public class HttpResult<T> {
    boolean status;
    String errmsg;
    @SerializedName("data")//注解 返回和本地字段不一样
     T msg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
