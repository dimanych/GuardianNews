package com.dimanych.guardiannews.ui.newslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.model.api.SimpleNews;
import com.dimanych.guardiannews.ui.BaseActivity;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;
import com.dimanych.guardiannews.ui.singlenews.NewsActivity;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.dimanych.guardiannews.util.Constants.NEWS;
import static com.dimanych.guardiannews.util.Constants.RESULTS;

public class NewsListActivity extends BaseActivity implements INewsListView, NewsAdapter.ItemListener {

    private List<Entity> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @BindView(R.id.news_recycler_view)
    RecyclerView newsRecycler;
    @BindView(R.id.progress_bar)
    ProgressBar loading;

    @Inject
    NewsListPresenter presenter;
    @Inject
    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_news_list);
        presenter.setView(this);
        initUI();
        presenter.loadNews();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(RESULTS, (ArrayList<Entity>) newsList);

    }

    private void initUI() {
        newsAdapter = new NewsAdapter(imageLoader, this);
        newsRecycler.setLayoutManager(new LinearLayoutManager(this));
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
        Toast.makeText(this, "Loading failed", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribeAll();
    }

    @Override
    public void onItemClick(SimpleNews news) {
        Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
        intent.putExtra(NEWS, news);
        startActivity(intent);
    }
}
