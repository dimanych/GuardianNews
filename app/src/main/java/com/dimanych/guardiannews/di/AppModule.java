package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.App;

import dagger.Module;

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

}
