package com.dimanych.guardiannews.rest.service;

import android.app.Service;
import android.content.Intent;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.ui.activity.NewsActivity;
import com.dimanych.guardiannews.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dimanych.guardiannews.util.Constants.RESULTS;
import static com.dimanych.guardiannews.util.Constants.STATUS;
import static com.dimanych.guardiannews.util.Constants.STATUS_FAIL;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsBodyCallback implements Callback<Entity> {

  private Service service;

  public NewsBodyCallback(Service service) {
    this.service = service;
  }

  @Override
  public void onResponse(Call<Entity> call, Response<Entity> response) {
    sendBroadcast(response.body(), Constants.STATUS_SUCCESS);
  }

  @Override
  public void onFailure(Call<Entity> call, Throwable t) {
    sendBroadcast(null, STATUS_FAIL);
  }

  private void sendBroadcast(Entity news, String status) {
    Intent intent = new Intent(NewsActivity.BROADCAST_TAG);
    intent.putExtra(STATUS, status);
    intent.putExtra(RESULTS, news);
    service.sendBroadcast(intent);
  }
}
