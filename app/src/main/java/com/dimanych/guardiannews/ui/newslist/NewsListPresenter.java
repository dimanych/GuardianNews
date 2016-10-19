package com.dimanych.guardiannews.ui.newslist;

import com.dimanych.guardiannews.base.BasePresenter;
import com.dimanych.guardiannews.rest.NewsApi;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;

import static com.dimanych.guardiannews.util.Constants.API_KEY_VALUE;
import static com.dimanych.guardiannews.util.Constants.THUMBNAIL;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsListPresenter extends BasePresenter<SectionFragment> {

    NewsApi newsApi;

    @Inject
    public NewsListPresenter(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public void loadNews(String section, int pageNumber) {
        subscribe(newsApi.getNewsList(section, API_KEY_VALUE, THUMBNAIL, pageNumber)
                .map(response -> response.response)
                .map(page -> page.results)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> getView().loadNews(news), throwable -> throwFail(throwable))
        );

    }

    private void throwFail(Throwable t) {
        t.printStackTrace();
        getView().loadFailed(t);
    }
}
