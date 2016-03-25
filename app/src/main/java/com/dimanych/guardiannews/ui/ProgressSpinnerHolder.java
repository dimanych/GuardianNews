package com.dimanych.guardiannews.ui;

import android.app.ProgressDialog;
import android.content.Context;
import com.dimanych.guardiannews.R;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ProgressSpinnerHolder {
  private Context context;
  ProgressDialog progressSpinner;

  public ProgressSpinnerHolder(Context context) {
    this.context = context;
  }

  /**
   * Создание и запуск прогрессбара spinner
   */
  public void runProgressSpinner() {
    progressSpinner = new ProgressDialog(context);
    progressSpinner.setIndeterminate(false);
    progressSpinner.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressSpinner.setMessage(context.getString(R.string.loading));
    progressSpinner.show();
  }

  public void dismiss() {
    progressSpinner.dismiss();
  }
}
