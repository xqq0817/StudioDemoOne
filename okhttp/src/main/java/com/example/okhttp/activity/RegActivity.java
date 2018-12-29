package com.example.okhttp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.okhttp.MainActivity;
import com.example.okhttp.R;
import com.example.okhttp.bean.UserBean;
import com.example.okhttp.contract.ILogincontract;
import com.example.okhttp.presenter.LogPresenter;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity implements ILogincontract.IloginView{

    private EditText mobile;
    private EditText password;
    private LogPresenter logPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_main);
        initData();
        initView();
    }
    //视图操作
    private void initView() {
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        logPresenter = new LogPresenter(this);
    }
   //数据操作
    private void initData() {
    }

    //注册按钮点击事件
    public void reg(View view){
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",mobile.getText().toString());
        map.put("password",password.getText().toString());
        logPresenter.reg(map);
    }
    @Override
    public void success(UserBean userBean) {
        Toast.makeText(RegActivity.this,userBean.getMsg()+"",Toast.LENGTH_SHORT).show();
        if (userBean.getMsg().equals("注册成功")){
            Intent intent = new Intent(RegActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void fail(String string) {
        Toast.makeText(RegActivity.this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mobileerror(String error) {
        Toast.makeText(RegActivity.this,error,Toast.LENGTH_SHORT).show();
    }
}
