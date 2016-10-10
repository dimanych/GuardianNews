package com.dimanych.guardiannews.ui;

import android.support.v7.app.AppCompatActivity;

import com.dimanych.guardiannews.di.AppComponent;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class BaseActivity extends AppCompatActivity {
    protected AppComponent component;

    public AppComponent getComponent() {
        return component;
    }
}
