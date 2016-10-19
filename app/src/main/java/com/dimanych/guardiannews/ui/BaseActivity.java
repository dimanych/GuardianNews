package com.dimanych.guardiannews.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.dimanych.guardiannews.di.activity.ActivityComponent;

import butterknife.ButterKnife;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityComponent activityComponent;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        initComponent();
    }

    protected abstract void initComponent();

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
