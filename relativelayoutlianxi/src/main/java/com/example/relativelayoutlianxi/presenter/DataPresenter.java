package com.example.relativelayoutlianxi.presenter;

import android.webkit.WebView;

import com.example.relativelayoutlianxi.entity.DataEntity;
import com.example.relativelayoutlianxi.model.DataModel;
import com.example.relativelayoutlianxi.utile.OkHttpUtils;
import com.example.relativelayoutlianxi.view.DataView;

import java.util.List;

public class DataPresenter {

    private DataView dataview;
    private DataView mView;

    public DataPresenter onCreate(DataView view) {
        this.mView=view;
        return this;
    }
    //初始化网络
    public void loadData(){
        //创建M层
        new DataModel().getData(OkHttpUtils.getInstance(), new DataModel.Callback() {
            @Override
            public void success(List<DataEntity.DataBean> data) {
                mView.success(data);
            }

            @Override
            public void defeated() {
                mView.defeated();
            }
        });
    }
}
