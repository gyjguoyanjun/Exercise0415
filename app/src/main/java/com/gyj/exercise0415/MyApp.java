package com.gyj.exercise0415;

import android.app.Application;

import org.xutils.x;


/**
 * 类的用途：
 * Created by 郭彦君
 * 2017/4/12
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
