package com.example.myapplication;

import android.app.Application;

import org.xutils.x;

/**
 * Created by vargo on 2017/1/13.
 */

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

        if (instance == null) {
            instance = this;
        }
    }


    public static App getInstance() {
        return instance;
    }
}

