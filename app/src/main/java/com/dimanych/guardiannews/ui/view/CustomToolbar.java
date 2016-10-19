package com.dimanych.guardiannews.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.util.Objects;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class CustomToolbar extends Toolbar {

    String title;
    Drawable leftBtnResId;
    Drawable rightBtnResId;
    boolean hideLeftBtn;

    LeftClickListener leftClickListener;
    RightClickListener rightClickListener;

    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    ImageView rightButton;
    @BindView(R.id.toolbar_title)
    TextView titleTextView;
    @BindDimen(R.dimen.margin_medium)
    int margin;

    public interface LeftClickListener {
        void onLeftClicked();
    }

    public interface RightClickListener {
        void onRightClicked();
    }


    public CustomToolbar(Context context) {
        super(context);
        init();
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        init();
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        init();
    }

    public void init( Context context, @Nullable AttributeSet attrs) {
        TypedArray attr = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.CustomToolbar, 0, 0);
        try {
            leftBtnResId = attr.getDrawable(R.styleable.CustomToolbar_left_button_icon);
            rightBtnResId = attr.getDrawable(R.styleable.CustomToolbar_right_button_icon);
            hideLeftBtn = attr.getBoolean(R.styleable.CustomToolbar_hide_left_button, false);
            title = attr.getString(R.styleable.CustomToolbar_toolbar_title);
        } finally {
            attr.recycle();
        }
    }

    public void init() {
        setContentInsetsAbsolute(margin, margin);
        inflate(getContext(), R.layout.toolbar_view, this);
        ButterKnife.bind(this);

        if (Objects.nonNull(leftBtnResId)) {
            leftButton.setImageDrawable(leftBtnResId);
        }
        if (Objects.nonNull(rightBtnResId)) {
            rightButton.setImageDrawable(rightBtnResId);
        }
        leftButton.setVisibility(hideLeftBtn ? GONE : VISIBLE);
        setTitle(title);
    }

    public CustomToolbar setLeftClickListener(LeftClickListener leftClickListener) {
        this.leftClickListener = leftClickListener;
        return this;
    }

    public CustomToolbar setRightClickListener(RightClickListener rightClickListener) {
        this.rightClickListener = rightClickListener;
        return this;
    }

    @Override
    public void setTitle(CharSequence title) {
        this.titleTextView.setText(title);
    }

    @OnClick(R.id.toolbar_left_button)
    public void onLeftClick() {
        if (leftClickListener != null) {
            leftClickListener.onLeftClicked();
        }
    }

    @OnClick(R.id.toolbar_right_button)
    public void onRightClick() {
        if (rightClickListener != null) {
            rightClickListener.onRightClicked();
        }
    }
}
