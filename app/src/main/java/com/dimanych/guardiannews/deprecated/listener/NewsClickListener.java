package com.dimanych.guardiannews.deprecated.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.dimanych.guardiannews.deprecated.NewsActivity;
import com.dimanych.guardiannews.ui.adapter.NewsAdapter;

import static com.dimanych.guardiannews.util.Constants.NEWS;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsClickListener implements AdapterView.OnItemClickListener {

    private Context context;
    private NewsAdapter adapter;

    public NewsClickListener(Context context, NewsAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(context, NewsActivity.class);
        intent.putExtra(NEWS, adapter.getEntity(position));
        context.startActivity(intent);
    }
}
