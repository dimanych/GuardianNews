package com.dimanych.guardiannews.rest;

import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.model.SimpleNews;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.dimanych.guardiannews.util.Constants.API_URL;
import static com.dimanych.guardiannews.util.Constants.FIELDS;
import static com.dimanych.guardiannews.util.Constants.RESPONSE;
import static com.dimanych.guardiannews.util.Constants.RESULTS;
import static com.dimanych.guardiannews.util.Constants.THUMBNAIL;
import static com.dimanych.guardiannews.util.Constants.WEB_PUBLICATION_DATE;
import static com.dimanych.guardiannews.util.Constants.WEB_TITLE;
import static com.dimanych.guardiannews.util.JsonUtils.getValue;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsListDeserializer implements JsonDeserializer<List<Entity>> {

  @Override
  public List<Entity> deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context) throws JsonParseException
  {
    List<Entity> newsList = new ArrayList();
    JsonObject responseObject = (JsonObject) json.getAsJsonObject().get(RESPONSE);
    JsonArray jsonArray = responseObject.getAsJsonArray(RESULTS);

    fillList(newsList, jsonArray);
    return newsList;
  }

  private void fillList(List<Entity> newsList, JsonArray jsonArray) {
    for (JsonElement element : jsonArray) {
      JsonObject jsonObject = element.getAsJsonObject();
      String webTitle = getValue(jsonObject, WEB_TITLE);
      String apiUrl = getValue(jsonObject, API_URL);
      Calendar webPublicationDate = getDate(jsonObject);
      String thumbnail = getThumbnail(jsonObject);
      newsList.add(new SimpleNews(webTitle, webPublicationDate, thumbnail, apiUrl));
    }
  }

  private Calendar getDate(JsonObject jsonObject) {
    String date = getValue(jsonObject, WEB_PUBLICATION_DATE);
    Calendar cal = Calendar.getInstance();
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      cal.setTime(dateFormat.parse(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return cal;
  }

  private String getThumbnail(JsonObject jsonObject) {
    JsonObject fieldsObject = (JsonObject) jsonObject.get(FIELDS);
    return getValue(fieldsObject, THUMBNAIL);
  }
}
