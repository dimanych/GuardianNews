package com.dimanych.guardiannews.ui.singlenews;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.api.Content;
import com.dimanych.guardiannews.model.api.SimpleNews;
import com.dimanych.guardiannews.ui.BaseActivity;
import com.dimanych.guardiannews.util.Constants;
import com.dimanych.guardiannews.util.CustomDateUtils;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class NewsActivity extends BaseActivity implements INewsView {

    @BindView(R.id.news_title)
    TextView newsTitle;
    @BindView(R.id.news_section)
    TextView newsSection;
    @BindView(R.id.news_created)
    TextView newsCreated;
    @BindView(R.id.progress_bar)
    ProgressBar loadingBar;

    @Inject
    NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_news);

        presenter.setView(this);
        SimpleNews news = getIntent().getParcelableExtra(Constants.NEWS);
        newsTitle.setText(news.webTitle);
        loadingBar.setVisibility(VISIBLE);
        presenter.loadSingleNews(news.id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribeAll();
    }

    @Override
    public void loadSingleNews(Content news) {
        newsSection.setText(news.sectionName);
        newsCreated.setText(CustomDateUtils.convertDateToStr(news.webPublicationDate));
        loadingBar.setVisibility(GONE);
    }
}
