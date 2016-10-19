package com.dimanych.guardiannews.ui;

import android.os.Bundle;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.di.activity.ActivityModule;
import com.dimanych.guardiannews.ui.newslist.NewsListFragment;
import com.dimanych.guardiannews.util.helper.NavigationHelper;

import javax.inject.Inject;

import static com.dimanych.guardiannews.util.Constants.TAG_NEWS_LIST_FRAGMENT;

public class MainActivity extends BaseActivity {

    @Inject
    NavigationHelper navigationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationHelper.addFragment(new NewsListFragment(), TAG_NEWS_LIST_FRAGMENT);
    }

    @Override
    protected void initComponent() {
        activityComponent = ((App) getApplication()).getAppComponent().plus(new ActivityModule(this));
        activityComponent.inject(this);
    }

}
