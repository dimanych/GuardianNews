package com.dimanych.guardiannews.rest;

import com.dimanych.guardiannews.model.Entity;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import static com.dimanych.guardiannews.util.Constants.CONTENT;
import static com.dimanych.guardiannews.util.Constants.RESPONSE;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsBodyDeserializer implements JsonDeserializer<Entity> {

  @Override
  public Entity deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException
  {
    JsonObject responseObject = (JsonObject) json.getAsJsonObject().get(RESPONSE);
    JsonObject jsonArray = (JsonObject) responseObject.get(CONTENT);
//    Entity news =
    return null;
  }
}
