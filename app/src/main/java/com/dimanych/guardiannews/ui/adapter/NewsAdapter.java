package com.dimanych.guardiannews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.Entity;
import com.dimanych.guardiannews.model.SimpleNews;
import com.dimanych.guardiannews.util.Objects;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsAdapter<T extends Entity> extends BaseAdapter {

  private Context context;
  private LayoutInflater inflater;
  private List<T> newsList;

  public NewsAdapter(Context context, List<T> newsList) {
    this.context = context;
    this.newsList = newsList;
    this.inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return newsList.size();
  }

  @Override
  public Object getItem(int position) {
    return newsList.get(position);
  }

  public T getEntity(int position)  {
    return (T) getItem(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if (Objects.isNull(view)) {
      view = inflater.inflate(R.layout.news_layout, parent, false);
    }
    T news = getEntity(position);
    fillUI(view, news);
    return view;
  }

  private void fillUI(View view, T newsEntity) {
    SimpleNews news = (SimpleNews) newsEntity;
    TextView webTitle = (TextView) view.findViewById(R.id.web_title);
    TextView webPublicationDate = (TextView) view.findViewById(R.id.publication_date);
    ImageView thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

    webTitle.setText(news.webTitle);
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
    String webPublicationDateStr = String.valueOf(sdf.format(news.webPublicationDate.getTime()));
    webPublicationDate.setText(webPublicationDateStr);
    Picasso.with(context)
      .load(news.thumbnail)
      .into(thumbnail);
  }

  public void update(List<T> results) {
    this.newsList = results;
    notifyDataSetChanged();
  }
}
