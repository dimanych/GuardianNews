package com.dimanych.guardiannews.di;

import com.dimanych.guardiannews.rest.NewsApi;
import com.dimanych.guardiannews.util.JsonUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

import static com.dimanych.guardiannews.util.Constants.API_HOST;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }

    @Singleton
    @Provides
    Retrofit provideREST(OkHttpClient httpClient) {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        return new Retrofit.Builder()
                .baseUrl(API_HOST)
                .addConverterFactory(GsonConverterFactory.create(JsonUtils.provideGson()))
                .client(httpClient)
                .addCallAdapterFactory(rxAdapter)
                .build();
    }

    @Provides
    NewsApi provideNewsApi(Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }
}
