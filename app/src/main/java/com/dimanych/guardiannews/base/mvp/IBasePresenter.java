package com.dimanych.guardiannews.base.mvp;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public interface IBasePresenter<T extends IBaseView> {
    void setView(T t);
    void unSubscribeAll();
}
