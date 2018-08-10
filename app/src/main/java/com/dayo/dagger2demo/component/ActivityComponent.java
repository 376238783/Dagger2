package com.dayo.dagger2demo.component;

import com.dayo.dagger2demo.MainActivity;
import com.dayo.dagger2demo.SecondActivity;
import com.dayo.dagger2demo.module.ActivityModule;
import com.dayo.dagger2demo.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity testActivity);
    void inject(SecondActivity testActivity);
}
