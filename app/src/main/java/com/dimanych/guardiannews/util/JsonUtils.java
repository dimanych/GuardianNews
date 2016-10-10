package com.dimanych.guardiannews.util;

import com.dimanych.guardiannews.model.SimpleNews;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;

import static com.dimanych.guardiannews.util.Constants.RESPONSE;

/**
 * <p>Утилита для работы с json</p>
 *
 * @author Dmitriy Grigoriev
 */
public class JsonUtils {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(SimpleNews.class, provideSimpleNews())
            .create();

    private static JsonDeserializer<SimpleNews> provideSimpleNews() {
        return (src, type, context) -> {
            JsonObject responseObject = (JsonObject) src.getAsJsonObject().get(RESPONSE);

            return null;
        };
    }

    public static Gson provideGson() {
        return GSON;
    }

    /**
     * Вытянуть строку по тэгу
     *
     * @param object json-объект
     * @param tag    тег поиска
     * @return подстрока, найденная по тегу tag
     */
    public static String getValue(JsonObject object, String tag) {
        if (Objects.nonNull(object)) {
            return object.get(tag).toString().replaceAll("\"", "");
        }
        return null;
    }

    /**
     * Вытянуть число по тэгу
     *
     * @param object json-объект
     * @param tag    тег поиска
     * @return число, найденное по тегу tag
     */
    public static Integer getIntegerValue(JsonObject object, String tag) {
        String value = getValue(object, tag);
        return Integer.valueOf(value);
    }


}
