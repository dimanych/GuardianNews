package com.dimanych.guardiannews;

import android.app.Application;

import com.dimanych.guardiannews.di.ApiModule;
import com.dimanych.guardiannews.di.AppComponent;
import com.dimanych.guardiannews.di.AppModule;
import com.dimanych.guardiannews.di.DaggerAppComponent;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class App extends Application {

    private AppComponent appComponent;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();

//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/robotolight.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getInstance() {
        return instance;
    }
}
