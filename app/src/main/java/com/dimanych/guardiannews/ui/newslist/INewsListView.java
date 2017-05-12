package com.dimanych.guardiannews.ui.newslist;

import com.dimanych.guardiannews.base.mvp.IBaseView;
import com.dimanych.guardiannews.model.api.SimpleNews;

import java.util.List;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public interface INewsListView extends IBaseView {

    void loadNews(List<SimpleNews> news);
    void loadFailed(Throwable t);
}
