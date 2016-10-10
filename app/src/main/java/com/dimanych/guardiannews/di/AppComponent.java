package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.ui.newslist.NewsListActivity;
import com.dimanych.guardiannews.ui.singlenews.NewsActivity;

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

    void inject(NewsListActivity newsListActivity);

    void inject(NewsActivity newsActivity);
}
