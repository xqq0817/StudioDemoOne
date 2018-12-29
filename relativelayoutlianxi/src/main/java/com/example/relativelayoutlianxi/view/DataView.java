package com.example.relativelayoutlianxi.view;

import com.example.relativelayoutlianxi.entity.DataEntity;

import java.util.List;

public interface DataView {
    //成功
    void success(List<DataEntity.DataBean> dataEntities);
    //失败
    void defeated();
}
