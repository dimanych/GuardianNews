package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.di.activity.ActivityComponent;
import com.dimanych.guardiannews.di.activity.ActivityModule;
import com.dimanych.guardiannews.ui.view.ArticleView;
import com.dimanych.guardiannews.ui.view.ImgView;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    ActivityComponent plus(ActivityModule activityModule);

    void inject(ArticleView articleView);

    void inject(ImgView articleImageView);

}
