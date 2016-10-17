package com.dimanych.guardiannews.ui;

import android.os.Bundle;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.ui.newslist.NewsListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsListFragment fragment = new NewsListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

}
