package com.dimanych.guardiannews.di.activity;

import com.dimanych.guardiannews.base.BaseActivity;
import com.dimanych.guardiannews.util.helper.NavigationHelper;

import dagger.Module;
import dagger.Provides;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
@Module
public class ActivityModule {

    private BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    BaseActivity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    NavigationHelper provideNavigationHelper(BaseActivity activity) {
        return new NavigationHelper(activity);
    }
}
