package com.dimanych.guardiannews.util;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public abstract class Constants {
    /**
     * Host
     */
    public static final String API_HOST = "https://content.guardianapis.com/";
    /**
     * API key
     */
    public static final String API_KEY_VALUE = "403e2fc8-136e-450b-b2a4-623faad17e0b";
    /**
     * Tags-filters for requesting to API
     */
    public static final String CONTENT = "content";
    public static final String SECTION = "section";
    public static final String SEARCH = "search";
    /**
     * Tags fields
     */
    public static final String API_KEY = "api-key";
    public static final String SHOW_FIELDS = "show-fields";
    public static final String FIELDS = "fields";
    public static final String NEWS = "news";
    public static final String THUMBNAIL = "thumbnail";
    public static final String ALL = "all";
    public static final String WEB_TITLE = "webTitle";
    public static final String API_URL = "apiUrl";
    public static final String API_LINK = "apiLink";
    public static final String WEB_PUBLICATION_DATE = "webPublicationDate";
    public static final String PAGE = "page";
    /**
     * News Sections
     */
    public static final String WORLD = "world";
    public static final String SPORT = "sport";
    public static final String CULTURE = "culture";
    public static final String BUSINESS = "business";
    public static final String LIFEANDSTYLE = "lifeandstyle";
    public static final String FASHION = "fashion";
    public static final String ENVIRONMENT = "environment";
    public static final String TECHNOLOGY = "technology";
    public static final String TRAVEL = "travel";
    public static final String SCIENCE = "science";
    public static final String MEDIA = "media";
    public static final String FILM = "film";
    public static final String MUSIC = "music";
    public static final String[] sections = {
            WORLD, SPORT, CULTURE, BUSINESS, LIFEANDSTYLE, FASHION, ENVIRONMENT, TECHNOLOGY, TRAVEL,
            SCIENCE, MEDIA, FILM, MUSIC};
    public static String TAG_NEWS_LIST_FRAGMENT = "NewsListFragment";
    public static String TAG_NEWS_FRAGMENT = "NewsFragment";
    /**
     *
     */
    public static final String EMPTY = "";
}
