package com.example.okhttpdaytwo.presenter;

import com.example.okhttpdaytwo.entity.UserEntity;
import com.example.okhttpdaytwo.model.LoginModel;
import com.example.okhttpdaytwo.net.RequestCallback;
import com.example.okhttpdaytwo.utile.ValidatorUtile;
import com.example.okhttpdaytwo.view.IloginView;

import java.util.HashMap;

public class LoginPresenter {
    private LoginModel loginModel;
    private IloginView iloginView;
    public LoginPresenter(IloginView iloginView){
        loginModel = new LoginModel();
        this.iloginView=iloginView;
    }
    public void login(HashMap<String,String> params){
        //正则表达式校验
        String mobile ="18201642540";
        String password = "11111111";
        if (!ValidatorUtile.isMobile(mobile)){
            if (iloginView!=null){
                iloginView.mobileError("请输入合法手机号");
            }
            return;//返回
        }

        //调用loginmodel的数据处理的方法，登录的方法
        if (loginModel!=null) {
            loginModel.login(params, new RequestCallback() {
                @Override
                public void failure(String msg) {
                    if (iloginView != null)
                        iloginView.failure(msg);
                }

                @Override
                public void successMsg(String msg) {
                    if (iloginView != null)
                        iloginView.successMsg(msg);
                }

                @Override
                public void success(UserEntity userEntity) {
                    if (iloginView != null)
                        iloginView.success(userEntity);
                }
            });
        }
    }
}
