package com.dayo.dagger2demo.bean;

import javax.inject.Inject;

public class BaseBean {
    private String name = "zyh";
    private String age = "18";

    @Inject
    public BaseBean(){}
//    @Override
//    public String toString() {
//        return "BaseBean{" +
//                "name='" + name + '\'' +
//                ", age='" + age + '\'' +
//                '}';
//    }

}
