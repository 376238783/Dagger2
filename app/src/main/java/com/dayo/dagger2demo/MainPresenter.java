package com.dayo.dagger2demo;

import android.util.Log;

import com.dayo.dagger2demo.bean.TestBean;
import com.dayo.dagger2demo.bean.WeatherBean;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {
    private ApiService apiService;

    @Inject
    public MainPresenter(@Named("z")TestBean bean, ApiService apiService){
        this.apiService = apiService;
        Log.e("Presenter..",bean.toString()+"="+apiService);
    }

    public void getData(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("cityname","北京");
        map.put("dtype","");
        map.put("format",1);
        map.put("key","65f04ee17b8edc80801a46ca5ff4502c");

        apiService.getWeatherBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherBean>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(WeatherBean weatherBean) {
                                   Log.e("onNext",""+weatherBean.toString());
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }
}
