package com.example.day2rkao.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration imageLoader=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(imageLoader);
    }
}
