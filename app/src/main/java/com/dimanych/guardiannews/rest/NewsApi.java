package com.dimanych.guardiannews.rest;

import com.dimanych.guardiannews.model.ResponseResults;
import com.dimanych.guardiannews.model.ResponseSingle;
import com.dimanych.guardiannews.model.SimpleNews;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.dimanych.guardiannews.util.Constants.API_KEY;
import static com.dimanych.guardiannews.util.Constants.API_LINK;
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
    Observable<ResponseResults<SimpleNews>> getNewsList(@Query(SECTION) String section,
                                                        @Query(API_KEY) String apiKey,
                                                        @Query(SHOW_FIELDS) String showFields);

    @GET("{apiLink}")
    Observable<ResponseSingle> getNews(@Path(value = API_LINK, encoded = true) String apiUrl,
                                       @Query(API_KEY) String apiKey,
                                       @Query(SHOW_FIELDS) String showFields);
}
