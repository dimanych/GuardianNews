package com.dimanych.guardiannews.ui.singlenews;

import com.dimanych.guardiannews.base.BasePresenter;
import com.dimanych.guardiannews.rest.NewsApi;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;

import static com.dimanych.guardiannews.util.Constants.ALL;
import static com.dimanych.guardiannews.util.Constants.API_KEY_VALUE;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsPresenter extends BasePresenter<NewsActivity> {

    NewsApi newsApi;

    @Inject
    public NewsPresenter(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public void loadSingleNews(String apiUrl) {

        subscribe(newsApi.getNews(apiUrl, API_KEY_VALUE, ALL)
                .map(responseResponseResults -> responseResponseResults.response)
                .map(response -> response.content)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> getView().loadSingleNews(news), Throwable::printStackTrace));
    }

}
