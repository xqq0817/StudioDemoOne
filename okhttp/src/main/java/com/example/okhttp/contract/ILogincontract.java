package com.example.okhttp.contract;

import com.example.okhttp.bean.UserBean;
import com.example.okhttp.net.ResponceCallBack;

import java.util.HashMap;

public interface ILogincontract {
    interface ILoginModel{
        void setokhttp(HashMap<String,String> map, String string, ResponceCallBack callBack);
    }
    interface IloginView{
        void success(UserBean userBean);
        void fail(String string);
        void mobileerror(String error);
    }

    abstract class ILogpresenter {
        public abstract void login(HashMap<String,String> map);
        public abstract void reg(HashMap<String,String> map);
    }
}
