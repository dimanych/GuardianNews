package com.dimanych.guardiannews.ui.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.base.BaseFragment;
import com.dimanych.guardiannews.ui.MainActivity;
import com.dimanych.guardiannews.ui.adapter.CustomPageAdapter;
import com.dimanych.guardiannews.util.helper.NavigationHelper;

import javax.inject.Inject;

import butterknife.BindView;

import static com.dimanych.guardiannews.util.Constants.sections;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsListFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    @Inject
    NavigationHelper navigationHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);
        initUI();
    }

    private void initUI() {
        for (String section : sections) {
            tabLayout.addTab(tabLayout.newTab().setText(section));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final CustomPageAdapter adapter = new CustomPageAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
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
