package com.binhlh.hometest;

import android.app.Application;

/**
 * Created by BINHLH on 28/08/2018.
 */

public class App extends Application {
    private static App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static App getInstance() {
        return INSTANCE;
    }
}
