package com.dimanych.guardiannews.di.activity;

import com.dimanych.guardiannews.ui.MainActivity;
import com.dimanych.guardiannews.ui.adapter.CustomPageAdapter;
import com.dimanych.guardiannews.ui.newslist.NewsListFragment;
import com.dimanych.guardiannews.ui.newslist.SectionFragment;
import com.dimanych.guardiannews.ui.singlenews.NewsFragment;

import dagger.Subcomponent;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(NewsFragment newsFragment);

    void inject(NewsListFragment newsListFragment);

    void inject(CustomPageAdapter customPageAdapter);

    void inject(SectionFragment sectionFragment);
}
