package com.example.okhttpdaytwo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.okhttpdaytwo.R;
import com.example.okhttpdaytwo.entity.UserEntity;
import com.example.okhttpdaytwo.model.IloginModel;
import com.example.okhttpdaytwo.presenter.LoginPresenter;
import com.example.okhttpdaytwo.view.IloginView;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements IloginView {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        initData();
    }
    //初始化数据
    private void initData() {
        presenter = new LoginPresenter(this);

    }
    /**
     * 点击，登录
     */
    public void login(View view){
        HashMap<String, String> params = new HashMap<>();
        params.put("model","18201642540");
        params.put("password","111111");
        if (presenter!=null){
            presenter.login(params);
        }
    }



    @Override
    public void mobileError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(UserEntity userEntity) {
        Toast.makeText(this,userEntity.msg+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
