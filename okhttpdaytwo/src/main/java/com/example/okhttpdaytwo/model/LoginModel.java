package com.example.okhttpdaytwo.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.okhttpdaytwo.api.UserApi;
import com.example.okhttpdaytwo.entity.UserEntity;
import com.example.okhttpdaytwo.net.RequestCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModel implements IloginModel{
    Handler handler = new Handler();
    @Override
    public void login(HashMap<String, String> params,final RequestCallback callback) {
        //新代码
        //okHttp网络框架的管理类
        OkHttpClient okhttp = new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
        //对请求体，构建数据的过程，构造者模式
        FormBody.Builder formbody = new FormBody.Builder();
        for (Map.Entry<String,String>p:params.entrySet()){
            formbody.add(p.getKey(),p.getValue());
        }

        //创建请求信息对象
        final Request requst = new Request.Builder().url(UserApi.TWO).post(formbody.build()).build();
        //创建请求执行对象
        Call call = okhttp.newCall(requst);
        //异步和同步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                if (callback != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络可能不稳定，请稍后再试");
                        }
                    });

                }
            }

            //成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();//返回的数据，json串
                int code = response.code();
                if (!TextUtils.isEmpty(result)) {
                    paserResult(result,callback,code);
                }
            }
        });


    }

    /**
     * 解析数据变成对象
     * @param result
     * @param callback
     * @param code
     */
    private void paserResult(String result,final RequestCallback callback,final int code) {
        final UserEntity userEntity = new Gson().fromJson(result, UserEntity.class);
        if (callback!=null){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.success(userEntity);
                }
            });
        }
    }
}
