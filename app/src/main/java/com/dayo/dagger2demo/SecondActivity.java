package com.dayo.dagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dayo.dagger2demo.bean.BaseBean;
import com.dayo.dagger2demo.bean.TestBaseBean;

import javax.inject.Inject;


public class SecondActivity extends AppCompatActivity {

    @Inject
    TestBaseBean base;
    @Inject
    TestBaseBean base1;
    @Inject
    BaseBean baseBean;
    @Inject
    ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        App.getInstance().getComponent().inject(this);
        TextView stv = findViewById(R.id.stv);

        stv.setText("TestBaseBean = "+base+"\nTestBaseBean1 = "+base1+"\n\nBaseBean = \n"+baseBean);
    }
}
