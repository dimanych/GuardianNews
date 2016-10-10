package com.dimanych.guardiannews.ui.singlenews;

import com.dimanych.guardiannews.base.IBaseView;
import com.dimanych.guardiannews.model.Content;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public interface INewsView extends IBaseView {

    void loadSingleNews(Content news);
}
