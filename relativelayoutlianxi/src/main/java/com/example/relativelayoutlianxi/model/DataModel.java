package com.example.relativelayoutlianxi.model;

import com.example.relativelayoutlianxi.api.API;
import com.example.relativelayoutlianxi.entity.DataEntity;
import com.example.relativelayoutlianxi.utile.OkHttpUtils;
import com.google.gson.Gson;

import java.util.List;


public class DataModel {
    public void getData(OkHttpUtils httpUtils,final Callback callback){
        httpUtils.getOkHttp(API.PATH, new OkHttpUtils.okHttp() {
            @Override
            public void success(String result) {
                //gson解析数据
                DataEntity dataEntity = new Gson().fromJson(result, DataEntity.class);
                List<DataEntity.DataBean> data = dataEntity.getData();
                callback.success(data);
            }

            @Override
            public void defeated() {
                callback.defeated();
            }
        });
    }
    //设置接口
    public interface Callback{
        //成功
        void success(List<DataEntity.DataBean> data);
        //失败
        void defeated();
    }
}
