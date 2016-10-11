package com.dimanych.guardiannews.ui.newslist;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.ui.BaseActivity;
import com.dimanych.guardiannews.ui.adapter.CustomPageAdapter;

import butterknife.BindView;

import static com.dimanych.guardiannews.util.Constants.BUSINESS;
import static com.dimanych.guardiannews.util.Constants.CULTURE;
import static com.dimanych.guardiannews.util.Constants.ENVIRONMENT;
import static com.dimanych.guardiannews.util.Constants.FASHION;
import static com.dimanych.guardiannews.util.Constants.LIFEANDSTYLE;
import static com.dimanych.guardiannews.util.Constants.SPORT;
import static com.dimanych.guardiannews.util.Constants.TECHNOLOGY;
import static com.dimanych.guardiannews.util.Constants.TRAVEL;
import static com.dimanych.guardiannews.util.Constants.WORLD;

public class NewsListActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        initUI();
    }

    private void initUI() {
        tabLayout.addTab(tabLayout.newTab().setText(WORLD));
        tabLayout.addTab(tabLayout.newTab().setText(SPORT));
        tabLayout.addTab(tabLayout.newTab().setText(CULTURE));
        tabLayout.addTab(tabLayout.newTab().setText(BUSINESS));
        tabLayout.addTab(tabLayout.newTab().setText(LIFEANDSTYLE));
        tabLayout.addTab(tabLayout.newTab().setText(FASHION));
        tabLayout.addTab(tabLayout.newTab().setText(ENVIRONMENT));
        tabLayout.addTab(tabLayout.newTab().setText(TECHNOLOGY));
        tabLayout.addTab(tabLayout.newTab().setText(TRAVEL));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final CustomPageAdapter adapter = new CustomPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
