package com.example.relativelayoutlianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.relativelayoutlianxi.adapter.RecyclerViewAdapter;
import com.example.relativelayoutlianxi.entity.DataEntity;
import com.example.relativelayoutlianxi.presenter.DataPresenter;
import com.example.relativelayoutlianxi.view.DataView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DataView {

    private RecyclerView main_recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //初始化数据
        initData();
    }
    //加载数据
    private void initData() {
        new DataPresenter().onCreate(this).loadData();
    }
    //加载资源ID
    private void initView() {
        main_recyclerView = findViewById(R.id.main_recyclerView);
        //创建适配器adapter
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this);
        main_recyclerView.setAdapter(recyclerViewAdapter);
        //设置布局管理
        /*main_recyclerView.setLayoutManager(new LinearLayoutManager(this,OrientationHelper.VERTICAL,false));*/
        //Gridview
        main_recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }


    @Override
    public void success(List<DataEntity.DataBean> dataEntities) {
        recyclerViewAdapter.setData(dataEntities);
    }

    @Override
    public void defeated() {

    }
}
