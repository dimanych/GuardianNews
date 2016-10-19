package com.dimanych.guardiannews.ui.singlenews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.annimon.stream.Optional;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.api.Content;
import com.dimanych.guardiannews.model.api.SimpleNews;
import com.dimanych.guardiannews.ui.BaseFragment;
import com.dimanych.guardiannews.ui.MainActivity;
import com.dimanych.guardiannews.ui.view.ArticleView;
import com.dimanych.guardiannews.ui.view.CustomToolbar;
import com.dimanych.guardiannews.util.Constants;
import com.dimanych.guardiannews.util.CustomDateUtils;
import com.dimanych.guardiannews.util.helper.ImageLoader;
import com.dimanych.guardiannews.util.helper.NavigationHelper;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.dimanych.guardiannews.util.Constants.EMPTY;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class NewsFragment extends BaseFragment implements INewsView, CustomToolbar.LeftClickListener {

    @BindView(R.id.news_toolbar)
    CustomToolbar toolbar;
    @BindView(R.id.news_title)
    TextView newsTitle;
    @BindView(R.id.thumbnail)
    ImageView thumbnailView;
    @BindView(R.id.news_trail)
    TextView newsTrail;
    @BindView(R.id.news_author)
    TextView newsAuthor;
    @BindView(R.id.news_created)
    TextView newsCreated;
    @BindView(R.id.progress_bar)
    ProgressBar loadingBar;
    @BindView(R.id.news_article)
    ArticleView newsArticle;

    @Inject
    NewsPresenter presenter;
    @Inject
    ImageLoader imageLoader;
    @Inject
    NavigationHelper navigationHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);

        presenter.setView(this);
        toolbar.setLeftClickListener(this);

        SimpleNews news = getArguments().getParcelable(Constants.NEWS);
        newsTitle.setText(news.webTitle);
        imageLoader.loadImage(news.field.thumbnail, thumbnailView);

        loadingBar.setVisibility(VISIBLE);
        presenter.loadSingleNews(news.id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unSubscribeAll();
    }

    @Override
    public void loadSingleNews(Content news) {
        newsAuthor.setText(Optional.ofNullable(news)
                .map(n -> n.field)
                .map(field -> field.byline)
                .orElse(EMPTY));
        newsCreated.setText(CustomDateUtils.convertDateToStr(news.webPublicationDate));
        newsArticle.setBody(Optional.ofNullable(news)
                .map(n -> n.field)
                .map(field -> field.body)
                .orElse(EMPTY));
        newsTrail.setText(Html.fromHtml(Optional.ofNullable(news)
                .map(n -> n.field)
                .map(field -> field.trailText)
                .orElse(EMPTY)));
        loadingBar.setVisibility(GONE);
    }

    @Override
    public void onLeftClicked() {
        navigationHelper.backStack();
    }
}
