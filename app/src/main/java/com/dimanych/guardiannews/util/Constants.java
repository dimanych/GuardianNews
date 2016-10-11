package com.dimanych.guardiannews.util;

/**
 * <p>Константы</p>
 *
 * @author Dmitriy Grigoriev
 */
public abstract class Constants {
    /**
     * Системные сообщения
     */
    public static final String NOT_YET_IMPLEMENTED = "Пока не реализовано";
    public static final String LOADING_FAILED = "Не удалось загрузить";
    /**
     * Ссылки
     */
    public static final String API_HOST = "https://content.guardianapis.com/";
    public static final String URL = "http://content.guardianapis.com/search?section=world&api-key=403e2fc8-136e-450b-b2a4-623faad17e0b&show-fields=thumbnail";
    /**
     * Теги-фильтры для запроса к API
     */
    public static final String CONTENT = "content";
    public static final String SECTION = "section";
    public static final String SEARCH = "search";
    /**
     * Теги-парсеры
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
    /**
     * Sections
     */
    public static final String WORLD = "world";
    public static final String SPORT = "sport";
    public static final String CULTURE = "culture";
    /**
     * API key
     */
    public static final String API_KEY_VALUE = "403e2fc8-136e-450b-b2a4-623faad17e0b";
    /**
     *
     */
    public static final String EMPTY = "";
}
