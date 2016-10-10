package com.dimanych.guardiannews.rest;

import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.model.ResponseData;
import com.dimanych.guardiannews.model.SimpleNews;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

import static com.dimanych.guardiannews.util.Constants.API_KEY;
import static com.dimanych.guardiannews.util.Constants.SEARCH;
import static com.dimanych.guardiannews.util.Constants.SECTION;
import static com.dimanych.guardiannews.util.Constants.SHOW_FIELDS;

/**
 * <p>
 * Сервис получения данных по API
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public interface NewsApi {
    /**
     * @return список Entity
     */
    @GET(SEARCH)
    Observable<ResponseData<SimpleNews>> getList(@Query(SECTION) String section,
                                                 @Query(API_KEY) String apiKey,
                                                 @Query(SHOW_FIELDS) String showFields);

    @GET
    Observable<Entity> getNewsEntity(@Query(API_KEY) String apiKey,
                               @Query(SHOW_FIELDS) String showFields);
}
