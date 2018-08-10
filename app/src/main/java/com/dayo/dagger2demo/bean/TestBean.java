package com.dayo.dagger2demo.bean;

import javax.inject.Inject;

public class TestBean {
    private String name;


    @Inject
    public TestBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
