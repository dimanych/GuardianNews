package com.dimanych.guardiannews.rest;

import com.dimanych.guardiannews.model.api.ListNewsPage;
import com.dimanych.guardiannews.model.api.ContentPage;
import com.dimanych.guardiannews.model.api.ResponseResults;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.dimanych.guardiannews.util.Constants.API_KEY;
import static com.dimanych.guardiannews.util.Constants.API_LINK;
import static com.dimanych.guardiannews.util.Constants.PAGE;
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
     * @return list of news by section
     */
    @GET(SEARCH)
    Observable<ResponseResults<ListNewsPage>> getNewsList(@Query(SECTION) String section,
                                                          @Query(API_KEY) String apiKey,
                                                          @Query(SHOW_FIELDS) String showFields,
                                                          @Query(PAGE) int pageNumber);
    /**
     * @return news by API link
     */
    @GET("{apiLink}")
    Observable<ResponseResults<ContentPage>> getNews(@Path(value = API_LINK, encoded = true) String apiUrl,
                                                     @Query(API_KEY) String apiKey,
                                                     @Query(SHOW_FIELDS) String showFields);
}
