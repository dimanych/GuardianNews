package com.dimanych.guardiannews.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.SimpleNews;
import com.dimanych.guardiannews.rest.service.LoadService;
import com.dimanych.guardiannews.rest.service.Receiver;
import com.dimanych.guardiannews.ui.ProgressSpinnerHolder;
import com.dimanych.guardiannews.util.Constants;
import com.dimanych.guardiannews.util.Objects;

import static com.dimanych.guardiannews.util.Constants.API_URL;
import static com.dimanych.guardiannews.util.Constants.DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.LOADING_FAILED;
import static com.dimanych.guardiannews.util.Constants.NEWS_BODY_DESERIALIZER;
import static com.dimanych.guardiannews.util.Constants.STATUS;
import static com.dimanych.guardiannews.util.Constants.STATUS_FAIL;
import static com.dimanych.guardiannews.util.Constants.STATUS_SUCCESS;

public class NewsActivity extends AppCompatActivity {

  public static final String BROADCAST_TAG = NewsListActivity.class.getCanonicalName();
  private ProgressSpinnerHolder progressSpinner = new ProgressSpinnerHolder(this);
  private Receiver receiver = createReceiver();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news);

    SimpleNews news = getIntent().getParcelableExtra(Constants.NEWS);
    TextView title = (TextView) findViewById(R.id.news_title);
    title.setText(news.webTitle);

    initData(savedInstanceState, news);
  }

  private void initData(Bundle savedInstanceState, SimpleNews news) {
    if (Objects.isNull(savedInstanceState)) {
      registerReceiver();
      progressSpinner.runProgressSpinner();
      Intent serviceIntent = new Intent(this, LoadService.class);
      serviceIntent.putExtra(DESERIALIZER, NEWS_BODY_DESERIALIZER);
      serviceIntent.putExtra(API_URL, "politics/blog/2014/feb/17/alex-salmond-speech-first-minister-scottish-independence-eu-currency-live");
//      serviceIntent.putExtra(API_URL, news.apiUrl);
      startService(serviceIntent);
    } else {

    }
  }

  private Receiver createReceiver() {
    return new Receiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
        String status = intent.getStringExtra(STATUS);
        switch (status) {
          case STATUS_SUCCESS: {

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

}
