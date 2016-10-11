package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.ui.newslist.NewsListActivity;
import com.dimanych.guardiannews.ui.newslist.SectionFragment;
import com.dimanych.guardiannews.ui.singlenews.NewsActivity;
import com.dimanych.guardiannews.ui.view.ImgView;
import com.dimanych.guardiannews.ui.view.ArticleView;

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

    void inject(ArticleView articleView);

    void inject(ImgView articleImageView);

    void inject(SectionFragment sectionFragment);
}
