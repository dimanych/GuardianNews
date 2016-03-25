package com.dimanych.guardiannews.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.listener.NewsClickListener;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.rest.service.LoadService;
import com.dimanych.guardiannews.rest.service.Receiver;
import com.dimanych.guardiannews.ui.ProgressSpinnerHolder;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;
import com.dimanych.guardiannews.util.Objects;

import java.util.ArrayList;
import java.util.List;

import static com.dimanych.guardiannews.util.Constants.DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.LOADING_FAILED;
import static com.dimanych.guardiannews.util.Constants.NEWS_LIST_DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.RESULTS;
import static com.dimanych.guardiannews.util.Constants.STATUS;
import static com.dimanych.guardiannews.util.Constants.STATUS_FAIL;
import static com.dimanych.guardiannews.util.Constants.STATUS_SUCCESS;

public class NewsListActivity extends AppCompatActivity {

  public static final String BROADCAST_TAG = NewsListActivity.class.getCanonicalName();

  private Receiver receiver = createReceiver();
  private ProgressSpinnerHolder progressSpinner = new ProgressSpinnerHolder(this);
  private List<Entity> newsList = new ArrayList<>();
  private NewsAdapter newsAdapter;

  private Receiver createReceiver() {
    return new Receiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
        String status = intent.getStringExtra(STATUS);
        switch (status) {
          case STATUS_SUCCESS: {
            newsList = intent.getParcelableArrayListExtra(RESULTS);
            newsAdapter.update(newsList);
            break;
          }
          case STATUS_FAIL: {
            Toast.makeText(getApplicationContext(), LOADING_FAILED, Toast.LENGTH_SHORT);
            break;
          }
        }
        progressSpinner.dismiss();
      }
    };
  }

  /**
   * Зарегистрировать получателя из сервиса
   */
  private void registerReceiver() {
    receiver.register(this, new IntentFilter(BROADCAST_TAG));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_list);
    initData(savedInstanceState);
    initUI();
  }

  private void initData(Bundle savedInstanceState) {
    if (Objects.isNull(savedInstanceState)) {
      registerReceiver();
      progressSpinner.runProgressSpinner();
      Intent serviceIntent = new Intent(this, LoadService.class);
      serviceIntent.putExtra(DESERIALIZER, NEWS_LIST_DESERIALIZER);
      startService(serviceIntent);
    } else {
      newsList = savedInstanceState.getParcelableArrayList(RESULTS);
      initUI();
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(RESULTS, (ArrayList<Entity>) newsList);

  }

  private void initUI() {
    newsAdapter = new NewsAdapter(this, newsList);
    ListView newsListView = (ListView) findViewById(R.id.news_list);
    newsListView.setAdapter(newsAdapter);
    newsListView.setOnItemClickListener(new NewsClickListener(this, newsAdapter));
  }

  @Override
  protected void onDestroy() {
    receiver.unregister(this);
    stopService(new Intent(this, LoadService.class));
    super.onDestroy();
  }
}
