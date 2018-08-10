package com.dayo.dagger2demo.component;

import com.dayo.dagger2demo.ApiService;
import com.dayo.dagger2demo.bean.BaseBean;
import com.dayo.dagger2demo.module.AppModule;
import com.dayo.dagger2demo.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 如果全局的Component已标识@Singleton,
 * 所有dependencies的子Component要想单例必须自定义@Scope标识，否则报错
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    //全局单例 Component依赖Module实例提供给@Inject使用
    BaseBean getBaseBean();
    ApiService getApiService();
}
