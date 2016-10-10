package com.dimanych.guardiannews.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.annimon.stream.Optional;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.SimpleNews;
import com.dimanych.guardiannews.util.Objects;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    ImageLoader imageLoader;
    private ItemListener listener;

    private List<SimpleNews> newsList = new ArrayList<>();

    public interface ItemListener {
        void onItemClick(SimpleNews news);
    }

    public NewsAdapter(ImageLoader imageLoader, ItemListener listener) {
        this.imageLoader = imageLoader;
        this.listener = listener;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.setNews(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected class NewsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.web_title)
        TextView webTitle;
        @BindView(R.id.publication_date)
        TextView webPublicationDate;
        @BindView(R.id.thumbnail)
        ImageView thumbView;

        private SimpleNews news;

        public NewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setNews(SimpleNews news) {
            this.news = news;
            webTitle.setText(news.webTitle);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
//        String webPublicationDateStr = String.valueOf(sdf.format(news.webPublicationDate.getTime()));
            String webPublicationDateStr = news.webPublicationDate;
            webPublicationDate.setText(webPublicationDateStr);

            if (Objects.nonNull(Optional.ofNullable(news)
                    .map(someNews -> someNews.field)
                    .map(field -> field.thumbnail)
                    .orElse(null)))
            {
                Observable.just(news.field.thumbnail)
                        .map(url -> url.replace("https", "http"))
                        .subscribe(url -> imageLoader.loadImage(url, thumbView),
                                Throwable::printStackTrace);
            }
        }

        @OnClick(R.id.news_item)
        public void onClickNewsItem() {
            listener.onItemClick(news);
        }
    }

    public void update(List<SimpleNews> results) {
        this.newsList.clear();
        this.newsList.addAll(results);
        notifyDataSetChanged();
    }
}
