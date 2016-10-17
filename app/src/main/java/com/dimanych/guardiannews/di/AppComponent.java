package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.ui.MainActivity;
import com.dimanych.guardiannews.ui.newslist.SectionFragment;
import com.dimanych.guardiannews.ui.singlenews.NewsFragment;
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

    void inject(MainActivity mainActivity);

    void inject(ArticleView articleView);

    void inject(ImgView articleImageView);

    void inject(SectionFragment sectionFragment);

    void inject(NewsFragment newsFragment);
}
