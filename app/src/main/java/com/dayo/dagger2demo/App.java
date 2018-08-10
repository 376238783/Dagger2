package com.dayo.dagger2demo;

import android.app.Application;

import com.dayo.dagger2demo.component.AppComponent;
import com.dayo.dagger2demo.component.DaggerActivityComponent;
import com.dayo.dagger2demo.component.DaggerAppComponent;

import com.dayo.dagger2demo.component.ActivityComponent;
import com.dayo.dagger2demo.module.AppModule;
import com.dayo.dagger2demo.module.NetModule;
import com.dayo.dagger2demo.module.ActivityModule;

public class App extends Application{

    private static App app;
    private AppComponent build;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        build = DaggerAppComponent.builder().appModule(new AppModule()).netModule(new NetModule()).build();

    }
    public static synchronized App getInstance() {
        return app;
    }

    public ActivityComponent getComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(build)//TestComponent依赖于全局的AppComponent
                .activityModule(new ActivityModule(app.getApplicationContext()))
                .build();
    }
}
