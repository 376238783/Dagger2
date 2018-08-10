package com.dayo.dagger2demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dayo.dagger2demo.bean.BaseBean;
import com.dayo.dagger2demo.bean.TestBaseBean;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    /**
     * @Inject 类的无参构造标识@Inject（例如TestPresenter类），既可提供实例
     */
    @Inject
    MainPresenter p;
    @Inject
    TestBaseBean testBaseBean; //局部实例
    @Inject
    TestBaseBean testBaseBeans;
    @Inject
    BaseBean baseBean; // 全局实例
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv =  findViewById(R.id.tv);

        App.getInstance().getComponent().inject(this);

        tv.setText("TestBaseBean = "+testBaseBean.toString()+"\nMainPresenter = "+p.toString()+"\nTestBaseBeans = "+testBaseBeans.toString()
        +"\n\nBaseBean = \n"+baseBean);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

        p.getData();
    }
}
