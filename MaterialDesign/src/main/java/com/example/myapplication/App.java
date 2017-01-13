package com.example.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by vargo on 2017/1/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}

