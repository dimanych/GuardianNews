package com.dimanych.guardiannews.ui.newslist;

import com.dimanych.guardiannews.base.IBaseView;
import com.dimanych.guardiannews.model.SimpleNews;

import java.util.List;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public interface INewsListView extends IBaseView {

    void loadNews(List<SimpleNews> news);
}
