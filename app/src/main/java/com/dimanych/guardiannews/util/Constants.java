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
  public static final String API_HOST = "http://content.guardianapis.com/";
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
  public static final String RESULTS = "results";
  public static final String RESPONSE = "response";
  public static final String API_KEY = "api-key";
  public static final String SHOW_FIELDS = "show-fields";
  public static final String FIELDS = "fields";
  public static final String NEWS = "news";
  public static final String THUMBNAIL = "thumbnail";
  public static final String WEB_TITLE = "webTitle";
  public static final String API_URL = "apiUrl";
  public static final String WEB_PUBLICATION_DATE = "webPublicationDate";
  public static final String WORLD = "world";
  /**
   *
   */
  public static final String DESERIALIZER = "deserializer";
  public static final String NEWS_BODY_DESERIALIZER = "NewsBodyDeserializer";
  public static final String NEWS_LIST_DESERIALIZER = "NewsListDeserializer";
  /**
   * Ключ для соединения к API
   */
  public static final String API_KEY_VALUE = "403e2fc8-136e-450b-b2a4-623faad17e0b";
  /**
   * Статусы загрузки
   */
  public static final String STATUS = "status";
  public static final String STATUS_FAIL = "FAIL";
  public static final String STATUS_SUCCESS = "SUCCESS";
}
