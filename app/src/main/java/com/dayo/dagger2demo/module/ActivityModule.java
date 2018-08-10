package com.dayo.dagger2demo.module;

import android.content.Context;

import com.dayo.dagger2demo.bean.TestBaseBean;
import com.dayo.dagger2demo.bean.TestBean;
import com.dayo.dagger2demo.scope.ActivityScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Context context;

    public ActivityModule(Context context){
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return  context;
    }

    /**
     * 局部单例 - 作用域跟Activity生命周期相等
     * Provides和Component,须@Scope或子注解标识
     *
     * @param testBean 此实例为同类(@Provides注解)方法提供
     */
    @Provides
    @ActivityScope
    TestBaseBean provideTestBaseBean(@Named("z")TestBean testBean){
       return new TestBaseBean(testBean);
    }

    /**
     * 如果对于不同的对象有同样的返回类型，我们可以使用@Named修饰符注解
     * 需要在提供实例的地方(@Provides注解)和注入的地方（@Inject注解）使用@Named注解。
     * @Named
     */
    @Named("z")
    @Provides
    public TestBean provideTestBean(){
        return  new TestBean("zhangyh");
    }

    @Named("l")
    @Provides
    TestBean providingTestBean(){
        return  new TestBean("ln");
    }


}
