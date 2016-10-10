package com.dimanych.guardiannews.ui.newslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.model.SimpleNews;
import com.dimanych.guardiannews.ui.BaseActivity;
import com.dimanych.guardiannews.ui.singlenews.NewsActivity;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static com.dimanych.guardiannews.util.Constants.NEWS;
import static com.dimanych.guardiannews.util.Constants.RESULTS;

public class NewsListActivity extends BaseActivity implements INewsListView, NewsAdapter.ItemListener {

    private List<Entity> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @BindView(R.id.news_recycler_view)
    RecyclerView newsRecycler;

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
    }

    @Override
    public void loadNews(List<SimpleNews> news) {
        newsAdapter.update(news);
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
