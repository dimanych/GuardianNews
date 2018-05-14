package com.dimanych.guardiannews.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.annimon.stream.Stream;
import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.model.api.Field;
import com.dimanych.guardiannews.util.StringUtils;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

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
        ((App) getContext().getApplicationContext()).getAppComponent().inject(this);
        setOrientation(VERTICAL);
    }

    public void setBody(Field field) {
        try {
            Document document = Jsoup.parse(field.body);
            Elements elements = document.select("body *");
//            makeCapital(createTextView(getFirstLine(elements)), elements.first().text());
//            elements.remove(0);
            for (Element element : elements) {
                switch (element.tag().getName()) {
                    case "p":
                    case "em":
                    case "br":
                    case "blockquote":
                        createTextView(element);
                        break;
                    case "h1":
                    case "h2":
                    case "h3":
                    case "h4":
                        HtmlTextView headTextView = new HtmlTextView(getContext());
                        headTextView.setHtml(element.toString(), new HtmlHttpImageGetter(headTextView));
                        headTextView.setPadding(0,30,0,30);
                        headTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.textColor));
                        addView(headTextView);
                        break;
                    case "img":
                        ImgView imgView = new ImgView(getContext());
                        imgView.setData(element.attr("src"), element.attr("alt"));
                        addView(imgView);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TextView textView = new TextView(getContext());
            textView.setText(field.bodyText);
            addView(textView);
        }
    }

    private Element getFirstLine(Elements elements) {
        Element element = Stream.of(elements)
                .findFirst()
                .filter(elem -> StringUtils.isEmpty(elem.text()))
                .stream()
                .findFirst()
                .orElse(elements.first());
        elements.remove(element);
        return element;
    }

    private TextView createTextView(Element element) {
        HtmlTextView textView = new HtmlTextView(getContext());
        try {
            String text = element.toString();
            text = text.replace("<strong>", "<b>");
            text = text.replace("</strong>", "</b>");
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.textColor));
            textView.setHtml(text, new HtmlHttpImageGetter(textView));
        } catch (IndexOutOfBoundsException e) {
            textView.setText(element.text());
        }
        addView(textView);
        return textView;
    }

    private void makeCapital(TextView textView, String title) {
        final SpannableString spannableString = new SpannableString(title);
        int position = 0;
        spannableString.setSpan(new RelativeSizeSpan(2.0f), position, position + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

}
