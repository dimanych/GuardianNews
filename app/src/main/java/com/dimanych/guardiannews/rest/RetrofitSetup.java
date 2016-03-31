package com.dimanych.guardiannews.rest;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>
 *   Логика работы библиотеки Retrofit
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public class RetrofitSetup {

  private JsonDeserializer jsonDeserializer;
  private Class classItem;

  /**
   * Создание сервиса для запросов к API
   * @return
   */
  @NonNull
  public ApiService createService(JsonDeserializer jsonDeserializer, Class classItem, String url) {
    this.jsonDeserializer = jsonDeserializer;
    this.classItem = classItem;
    return createRetrofit(url).create(ApiService.class);
  }

  /**
   * Инициализация Retrofit
   */
  @NonNull
  private Retrofit createRetrofit(String url) {
    return new Retrofit.Builder()
      .baseUrl(url)
      .addConverterFactory(createFactory())
      .build();
  }

  /**
   * Создание фабрики
   * @return фабрика-конвертер gson
   */
  private Converter.Factory createFactory() {
    Gson gson = new GsonBuilder()
      .registerTypeAdapter(classItem, jsonDeserializer)
      .create();
    return GsonConverterFactory.create(gson);
  }
}
