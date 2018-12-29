package com.example.okhttp.presenter;

import com.example.okhttp.api.UserApi;
import com.example.okhttp.bean.UserBean;
import com.example.okhttp.contract.ILogincontract;
import com.example.okhttp.model.LoginModel;
import com.example.okhttp.net.ResponceCallBack;
import com.example.okhttp.utile.ValidatorUtil;

import java.util.HashMap;

public class LogPresenter  extends ILogincontract.ILogpresenter{

    private final LoginModel loginModel;
    private ILogincontract.IloginView iloginView;
    public LogPresenter(ILogincontract.IloginView iloginView){
        loginModel = new LoginModel();
        this.iloginView=iloginView;
    }
    //登录的方法
    @Override
    public void login(HashMap<String, String> map) {
        String mobile= map.get("mobile");
        if (!ValidatorUtil.isMobile(mobile)){
            iloginView.mobileerror("手机号不合法");
            return;
        }
        loginModel.setokhttp(map, UserApi.USER_LOGIN, new ResponceCallBack() {
            @Override
            public void success(UserBean userBean) {
                if (userBean!=null){
                    iloginView.success(userBean);
                }
            }

            @Override
            public void fail(String string) {
                iloginView.fail(string);
            }
        });
    }

    @Override
    public void reg(HashMap<String, String> map) {
        String mobile= map.get("mobile");
        if (!ValidatorUtil.isMobile(mobile)){
            iloginView.mobileerror("手机号不合法");
            return;
        }
        loginModel.setokhttp(map, UserApi.USER_REG, new ResponceCallBack() {
            @Override
            public void success(UserBean userBean) {
                if (userBean != null) {
                    iloginView.success(userBean);
                }
            }

            @Override
            public void fail(String string) {
                iloginView.fail(string);
            }
        });
    }
}
