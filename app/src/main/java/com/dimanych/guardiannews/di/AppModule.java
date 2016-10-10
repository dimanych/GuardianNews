package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(App context) {
        return new ImageLoader(context);
    }
}
