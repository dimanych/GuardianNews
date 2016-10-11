package com.dimanych.guardiannews.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dimanych.guardiannews.ui.newslist.SectionFragment;

import static com.dimanych.guardiannews.util.Constants.CULTURE;
import static com.dimanych.guardiannews.util.Constants.SECTION;
import static com.dimanych.guardiannews.util.Constants.SPORT;
import static com.dimanych.guardiannews.util.Constants.WORLD;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class CustomPageAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;

    public CustomPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        String section = null;
        switch (position) {
            case 0:
                section = WORLD;
                break;
            case 1:
                section = SPORT;
                break;
            case 2:
                section = CULTURE;
                break;
        }
        Fragment fragment = new SectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SECTION, section);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
