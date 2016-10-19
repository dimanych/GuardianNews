package com.dimanych.guardiannews.ui.newslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.api.SimpleNews;
import com.dimanych.guardiannews.ui.BaseFragment;
import com.dimanych.guardiannews.ui.MainActivity;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;
import com.dimanych.guardiannews.ui.singlenews.NewsFragment;
import com.dimanych.guardiannews.util.helper.ImageLoader;
import com.dimanych.guardiannews.util.helper.NavigationHelper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.dimanych.guardiannews.util.Constants.NEWS;
import static com.dimanych.guardiannews.util.Constants.SECTION;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class SectionFragment extends BaseFragment implements INewsListView, NewsAdapter.ItemListener {

    private NewsAdapter newsAdapter;
    private String section;

    @BindView(R.id.news_recycler_view)
    RecyclerView newsRecycler;
    @BindView(R.id.progress_bar)
    ProgressBar loading;

    @Inject
    NewsListPresenter presenter;
    @Inject
    ImageLoader imageLoader;
    @Inject
    NavigationHelper navigationHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_section, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);
        presenter.setView(this);
        initUI();
        presenter.loadNews(section);
    }

    private void initUI() {
        section = getArguments().getString(SECTION);
        newsAdapter = new NewsAdapter(imageLoader, this);
        newsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecycler.setAdapter(newsAdapter);
        loading.setVisibility(VISIBLE);

    }


    @Override
    public void loadNews(List<SimpleNews> news) {
        newsAdapter.update(news);
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
        presenter.unSubscribeAll();
    }

    @Override
    public void onItemClick(SimpleNews news) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(NEWS, news);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(bundle);
        navigationHelper.addFragment(fragment);
    }
}
