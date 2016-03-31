package com.dimanych.guardiannews.rest;

import com.dimanych.guardiannews.model.Entity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

import static com.dimanych.guardiannews.util.Constants.API_KEY;
import static com.dimanych.guardiannews.util.Constants.SEARCH;
import static com.dimanych.guardiannews.util.Constants.SECTION;
import static com.dimanych.guardiannews.util.Constants.SHOW_FIELDS;

/**
 * <p>
 *   Сервис получения данных по API
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public interface ApiService {
  /**
   * @return список Entity
   */
  @GET(SEARCH)
  Call<List<Entity>> getList(@Query(SECTION) String section,
                             @Query(API_KEY) String apiKey,
                             @Query(SHOW_FIELDS) String showFields);

  @GET
  Call<Entity> getNewsEntity(@Query(API_KEY) String apiKey,
                             @Query(SHOW_FIELDS) String showFields);
}
