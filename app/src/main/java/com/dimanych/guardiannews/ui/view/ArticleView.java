package com.dimanych.guardiannews.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.inject.Inject;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ArticleView extends LinearLayout {

    @Inject
    ImageLoader imageLoader;

    public ArticleView(Context context) {
        super(context);
        init();
    }

    public ArticleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ArticleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        App.getInstance().getAppComponent().inject(this);
        setOrientation(VERTICAL);
    }

    public void setBody(String body) {
        Document document = Jsoup.parse(body);
        Elements elements = document.select("body *");
        for (Element element : elements) {
            switch (element.tag().getName()) {
                case "p":
                    TextView textView = new TextView(getContext());
                    textView.setText(element.text());
                    addView(textView);
                    break;
                case "img":
                    ImgView imgView = new ImgView(getContext());
                    imgView.setData(element.attr("src"), element.attr("alt"));
                    addView(imgView);
                    break;
            }
        }
    }

    private void setCapital(String body) {
        TextView capitalView = new TextView(getContext());
        capitalView.setText(String.valueOf(body.charAt(3)));
        if (Build.VERSION.SDK_INT < 23) {
            capitalView.setTextAppearance(getContext(), R.style.CapitalTextTheme);
        } else{
            capitalView.setTextAppearance(R.style.CapitalTextTheme);
        }
        addView(capitalView);
    }

}
