package com.dimanych.guardiannews.ui.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.api.SimpleNews;
import com.dimanych.guardiannews.base.BaseFragment;
import com.dimanych.guardiannews.ui.MainActivity;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;
import com.dimanych.guardiannews.ui.singlenews.NewsFragment;
import com.dimanych.guardiannews.ui.view.ProgressBarView;
import com.dimanych.guardiannews.util.helper.ImageLoader;
import com.dimanych.guardiannews.util.helper.NavigationHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.reginald.swiperefresh.CustomSwipeRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.dimanych.guardiannews.util.Constants.NEWS;
import static com.dimanych.guardiannews.util.Constants.SECTION;
import static com.dimanych.guardiannews.util.Constants.TAG_NEWS_FRAGMENT;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class SectionFragment extends BaseFragment implements INewsListView, NewsAdapter.ItemListener {

    private NewsAdapter mNewsAdapter;
    private String mSection;

    @BindView(R.id.news_recycler_view)
    ObservableRecyclerView mNewsRecycler;
    @BindView(R.id.custom_refresh_layout)
    CustomSwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.progress_bar)
    ProgressBar loading;

    @Inject
    NewsListPresenter mPresenter;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    NavigationHelper mNavigationHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_section, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);
        mPresenter.setView(this);
        initUI();
        mPresenter.loadNews(mSection, 1);
    }

    private void initUI() {
        mSection = getArguments().getString(SECTION);
        mNewsAdapter = new NewsAdapter(mImageLoader, this);
        mNewsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsRecycler.setAdapter(mNewsAdapter);
        mRefreshLayout.setOnRefreshListener(() -> mPresenter.loadNews(mSection, 1));
        mRefreshLayout.setCustomHeadview(new ProgressBarView(getActivity()));
        mPresenter.loadNews(mSection, 1);
        loading.setVisibility(VISIBLE);
    }


    @Override
    public void loadNews(List<SimpleNews> news) {
        mNewsAdapter.update(news);
        mRefreshLayout.refreshComplete();
        loading.setVisibility(GONE);
    }

    @Override
    public void loadFailed(Throwable t) {
        Toast.makeText(getContext(), "Loading failed", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unSubscribeAll();
    }

    @Override
    public void onItemClick(SimpleNews news) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(NEWS, news);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(bundle);
        mNavigationHelper.addFragment(fragment, TAG_NEWS_FRAGMENT);
    }

    @Override
    public void onSwipedEnd(int nextPage) {
        mPresenter.loadNews(mSection, nextPage);
    }
}
