package com.example.day2rkao.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.day2rkao.R;
import com.example.day2rkao.adapter.MAdapter;
import com.example.day2rkao.gsonbean.Bean;
import com.example.day2rkao.utile.HttpUtile;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView plv;
    private List<Bean.DataBean> list=new ArrayList<>();
    private MAdapter mAdapter;
    private String url="http://120.27.23.105/product/getProducts?pscid=39&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plv = findViewById(R.id.plv);
        mAdapter = new MAdapter(MainActivity.this, list);
        plv.setAdapter(mAdapter);
        new MyTask().execute(url);

    }
    class MyTask extends AsyncTask<String,Void,List<Bean.DataBean>>{

        @Override
        protected List<Bean.DataBean> doInBackground(String... strings) {
            String s = HttpUtile.get(strings[0]);
            Bean bean = new Gson().fromJson(s, Bean.class);
            return bean.getData();
        }

        @Override
        protected void onPostExecute(List<Bean.DataBean> dataBeans) {
            super.onPostExecute(dataBeans);
            list.addAll(dataBeans);
            mAdapter.notifyDataSetChanged();
        }
    }
}
