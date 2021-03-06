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

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
