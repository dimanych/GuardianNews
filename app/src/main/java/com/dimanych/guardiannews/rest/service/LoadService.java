package com.dimanych.guardiannews.rest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.dimanych.guardiannews.rest.RetrofitSetup;

import static com.dimanych.guardiannews.util.Constants.NOT_YET_IMPLEMENTED;


/**
 * <p>
 * Сервис для фоновой загрузки данных по API
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public class LoadService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        RetrofitSetup retrofitSetup = new RetrofitSetup();

//        retrofitSetup
//                .createService(new NewsListDeserializer(), List.class, API_HOST)
//                .getList(WORLD, API_KEY_VALUE, THUMBNAIL)
//                .enqueue(new NewsListCallback(this));

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException(NOT_YET_IMPLEMENTED);
    }

}
