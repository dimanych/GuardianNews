package com.dimanych.guardiannews.util.helper;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.ui.BaseActivity;
import com.dimanych.guardiannews.ui.BaseFragment;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NavigationHelper {

    BaseActivity activity;

    public NavigationHelper(BaseActivity activity) {
        this.activity = activity;
    }

    public void addFragment(BaseFragment fragment) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
