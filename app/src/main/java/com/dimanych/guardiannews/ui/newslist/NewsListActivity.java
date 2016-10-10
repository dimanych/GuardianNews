package com.dimanych.guardiannews.ui.newslist;

import android.os.Bundle;
import android.widget.ListView;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.model.SimpleNews;
import com.dimanych.guardiannews.ui.BaseActivity;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;
import com.dimanych.guardiannews.ui.listener.NewsClickListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.dimanych.guardiannews.util.Constants.RESULTS;

public class NewsListActivity extends BaseActivity implements INewsView {

    private List<Entity> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Inject
    NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ((App) getApplication()).getAppComponent().inject(this);
        presenter.setView(this);
        initUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(RESULTS, (ArrayList<Entity>) newsList);

    }

    private void initUI() {
        newsAdapter = new NewsAdapter(this, newsList);
        ListView newsListView = (ListView) findViewById(R.id.news_list);
        newsListView.setAdapter(newsAdapter);
        newsListView.setOnItemClickListener(new NewsClickListener(this, newsAdapter));
        presenter.loadNews();
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
}
