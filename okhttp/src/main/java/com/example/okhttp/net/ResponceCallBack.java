package com.example.okhttp.net;

import com.example.okhttp.bean.UserBean;

public interface ResponceCallBack {
    void success(UserBean userbean);
    void fail(String string);
}
