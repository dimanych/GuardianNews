package com.dimanych.guardiannews.ui.view;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dimanych.guardiannews.App;
import com.dimanych.guardiannews.R;
import com.dimanych.guardiannews.util.helper.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ImgView extends LinearLayout {

    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.alt)
    TextView altView;

    @Inject
    ImageLoader imageLoader;

    public ImgView(Context context) {
        super(context);
        init();
    }

    public ImgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImgView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        App.getInstance().getAppComponent().inject(this);
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.img_view, this, true);
        ButterKnife.bind(this);
    }

    public void setData(String url, String alt) {
        imageLoader.loadImage(url, imageView);
        altView.setText(alt);
        imageView.setOnClickListener(v -> showImageFullscreen(url));
    }

    private void showImageFullscreen(String url) {
        Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        ImageView iView = new ImageView(getContext());
        imageLoader.loadImage(url, iView);
        dialog.setContentView(iView);
        iView.setOnClickListener(v1 -> dialog.dismiss());
        dialog.show();
    }
}
