package com.dimanych.guardiannews.util;

import com.google.gson.JsonObject;

/**
 * <p>Утилита для работы с json</p>
 *
 * @author Dmitriy Grigoriev
 */
public class JsonUtils {
  /**
   * Вытянуть строку по тэгу
   *
   * @param object json-объект
   * @param tag тег поиска
   * @return подстрока, найденная по тегу tag
   */
  public static String getValue(JsonObject object, String tag) {
    return object.get(tag).toString().replaceAll("\"", "");
  }
  /**
   * Вытянуть число по тэгу
   *
   * @param object json-объект
   * @param tag тег поиска
   * @return число, найденное по тегу tag
   */
  public static Integer getIntegerValue(JsonObject object, String tag) {
    String value = getValue(object, tag);
    return Integer.valueOf(value);
  }
}
