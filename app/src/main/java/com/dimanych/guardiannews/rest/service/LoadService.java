package com.dimanych.guardiannews.rest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.rest.NewsBodyDeserializer;
import com.dimanych.guardiannews.rest.NewsListDeserializer;
import com.dimanych.guardiannews.rest.RetrofitSetup;

import java.util.List;

import static com.dimanych.guardiannews.util.Constants.API_KEY_VALUE;
import static com.dimanych.guardiannews.util.Constants.API_URL;
import static com.dimanych.guardiannews.util.Constants.DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.NEWS_BODY_DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.NEWS_LIST_DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.NOT_YET_IMPLEMENTED;
import static com.dimanych.guardiannews.util.Constants.THUMBNAIL;
import static com.dimanych.guardiannews.util.Constants.WORLD;


/**
 * <p>
 *   Сервис для фоновой загрузки данных по API
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public class LoadService extends Service {

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    String deserializer = intent.getStringExtra(DESERIALIZER);
    RetrofitSetup retrofitSetup = new RetrofitSetup();
    switch (deserializer) {
      case NEWS_LIST_DESERIALIZER: {
        retrofitSetup
          .createService(new NewsListDeserializer(), List.class)
          .getList(WORLD, API_KEY_VALUE, THUMBNAIL)
          .enqueue(new NewsListCallback(this));
      }
      case NEWS_BODY_DESERIALIZER: {
        String apiUrl = intent.getStringExtra(API_URL);
        retrofitSetup
          .createService(new NewsBodyDeserializer(), Entity.class)
          .getNewsEntity(apiUrl, API_KEY_VALUE, "body")
          .enqueue(new NewsBodyCallback(this));
      }
    }


    return super.onStartCommand(intent, flags, startId);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    throw new UnsupportedOperationException(NOT_YET_IMPLEMENTED);
  }

}
