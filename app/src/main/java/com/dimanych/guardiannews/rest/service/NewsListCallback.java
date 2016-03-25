package com.dimanych.guardiannews.rest.service;

import android.app.Service;
import android.content.Intent;
import com.dimanych.guardiannews.ui.activity.NewsListActivity;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

import static com.dimanych.guardiannews.util.Constants.RESULTS;
import static com.dimanych.guardiannews.util.Constants.STATUS;
import static com.dimanych.guardiannews.util.Constants.STATUS_FAIL;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsListCallback implements Callback<List<Entity>> {

  private Service service;

  public NewsListCallback(Service service) {
    this.service = service;
  }

  @Override
  public void onResponse(Call<List<Entity>> call, Response<List<Entity>> response) {
    sendBroadcast((ArrayList<Entity>) response.body(), Constants.STATUS_SUCCESS);
  }

  @Override
  public void onFailure(Call<List<Entity>> call, Throwable t) {
    sendBroadcast(new ArrayList<Entity>(), STATUS_FAIL);
  }

  private void sendBroadcast(ArrayList<Entity> entityList, String status) {
    Intent intent = new Intent(NewsListActivity.BROADCAST_TAG);
    intent.putExtra(STATUS, status);
    intent.putParcelableArrayListExtra(RESULTS, entityList);
    service.sendBroadcast(intent);
  }
}
