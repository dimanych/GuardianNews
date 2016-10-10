package com.dimanych.guardiannews.base;

import java.lang.ref.WeakReference;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    private WeakReference<T> view;
    private CompositeSubscription subs = new CompositeSubscription();

    @Override
    public void setView(T t) {
        view = new WeakReference<>(t);
    }

    @Override
    public void unSubscribeAll() {
        if (subs.hasSubscriptions()) subs.clear();
    }

    protected final void subscribe(Subscription subscription) {
        subs.add(subscription);
    }

    protected T getView() {
        return view.get();
    }
}
