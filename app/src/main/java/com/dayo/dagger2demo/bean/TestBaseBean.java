package com.dayo.dagger2demo.bean;

import javax.inject.Inject;

public class TestBaseBean {
    private TestBean testBean;
    private String time="2018-06-14";
    @Inject
    public TestBaseBean(TestBean testBean){
        this.testBean = testBean;
    }



//    @Override
//    public String toString() {
//        return "TestBaseBean{" +
//                "testBean=" + testBean +
//                ", time='" + time + '\'' +
//                '}';
//    }
}
