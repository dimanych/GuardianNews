package com.dimanych.guardiannews.rest;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.dimanych.guardiannews.util.Constants.API_HOST;

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
  public ApiService createService(JsonDeserializer jsonDeserializer, Class classItem) {
    this.jsonDeserializer = jsonDeserializer;
    this.classItem = classItem;
    return createRetrofit().create(ApiService.class);
  }

  /**
   * Инициализация Retrofit
   */
  @NonNull
  private Retrofit createRetrofit() {
    return new Retrofit.Builder()
      .baseUrl(API_HOST)
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
