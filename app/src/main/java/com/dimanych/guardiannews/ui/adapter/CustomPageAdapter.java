package com.dimanych.guardiannews.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dimanych.guardiannews.ui.newslist.SectionFragment;

import static com.dimanych.guardiannews.util.Constants.SECTION;
import static com.dimanych.guardiannews.util.Constants.sections;

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
        Fragment fragment = new SectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SECTION, sections[position]);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
