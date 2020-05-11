package com.huantai.httpdemo.Utils;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {
    public static void test(){

        //观察者
        Observer observer = new Observer() {
            Disposable dd = null;

            @Override
            public void onSubscribe(Disposable d) {
                dd = d;

            }

            @Override
            public void onNext(Object o) {

                Log.e("obl",o.toString()+Thread.currentThread().getName());
                if(o.toString().equals("2")){
                    dd.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        //观察者是Observer的扩展类
        Subscriber subscriber = new Subscriber<String>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

        };

//        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter e) throws Exception {
//                e.onNext("1");
//                Log.e("obl","1"+Thread.currentThread().getName());
//                e.onNext("2");
//                Log.e("obl","2"+Thread.currentThread().getName());
//                e.onNext("3");
//                Log.e("obl","3"+Thread.currentThread().getName());
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread());
//
////        observable.subscribeOn(Schedulers.newThread());
////        observable.observeOn(AndroidSchedulers.mainThread());
//        observable.subscribe(observer);



        Observable.just("1","2","3").flatMap(new Function<String, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(String s) throws Exception {
                Log.e("obl",s+Thread.currentThread().getName());
                return Observable.just(s);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
