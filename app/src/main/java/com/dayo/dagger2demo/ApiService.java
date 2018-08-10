package com.dayo.dagger2demo;

import com.dayo.dagger2demo.bean.WeatherBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface ApiService {//接口
    @GET("index")
    Observable<WeatherBean> getWeatherBean(@QueryMap Map<String,Object> map);
}
