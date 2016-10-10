package com.dimanych.guardiannews.ui.newslist;

import com.dimanych.guardiannews.base.BasePresenter;
import com.dimanych.guardiannews.rest.NewsApi;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;

import static com.dimanych.guardiannews.util.Constants.API_KEY_VALUE;
import static com.dimanych.guardiannews.util.Constants.THUMBNAIL;
import static com.dimanych.guardiannews.util.Constants.WORLD;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsPresenter extends BasePresenter<NewsListActivity> {

    NewsApi newsApi;

    @Inject
    public NewsPresenter(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public void loadNews() {
        subscribe(newsApi.getList(WORLD, API_KEY_VALUE, THUMBNAIL)
                .map(responseData -> responseData.response)
                .map(response -> response.data)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> getView().loadNews(news),
                        Throwable::printStackTrace)
        );

    }
}
