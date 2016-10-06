package com.dimanych.guardiannews.rest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.rest.NewsBodyDeserializer;
import com.dimanych.guardiannews.rest.RetrofitSetup;

import static com.dimanych.guardiannews.util.Constants.API_KEY_VALUE;
import static com.dimanych.guardiannews.util.Constants.API_URL;
import static com.dimanych.guardiannews.util.Constants.NOT_YET_IMPLEMENTED;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class SingleNewsService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        RetrofitSetup retrofitSetup = new RetrofitSetup();
        String apiUrl = intent.getStringExtra(API_URL);

        retrofitSetup
                .createService(new NewsBodyDeserializer(), Entity.class, apiUrl)
                .getNewsEntity(API_KEY_VALUE, "body")
                .enqueue(new NewsBodyCallback(this));

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException(NOT_YET_IMPLEMENTED);
    }
}
