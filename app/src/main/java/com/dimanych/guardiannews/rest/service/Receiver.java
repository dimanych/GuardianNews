package com.dimanych.guardiannews.rest.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/**
 * <p>
 *   Получатель ответа от сервиса.
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public abstract class Receiver extends BroadcastReceiver {

  /**
   * флаг регистрации
   */
  private boolean isRegistered;

  /**
   * Зарегистрировать BroadcastReceiver
   */
  public void register(Context context, IntentFilter filter) {
    isRegistered = true;
    context.registerReceiver(this, filter);
  }

  /**
   * Закрыть регистрацию BroadcastReceiver
   */
  public void unregister(Context context) {
    if (isRegistered) {
      context.unregisterReceiver(this);
      isRegistered = false;
    }
  }
}
