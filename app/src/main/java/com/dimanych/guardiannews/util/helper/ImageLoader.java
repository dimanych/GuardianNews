package com.dimanych.guardiannews.util.helper;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ImageLoader {
    private Context context;

    @Inject
    public ImageLoader(Context context) {

        this.context = context;
    }

    public void loadImageCenterCrop(String url, ImageView imageView) {
        loadImageCenterCrop(Uri.parse(url), imageView);
    }

    public void loadImageCenterCrop(Uri uri, ImageView imageView) {
        Glide.with(context)
                .load(uri)
                .into(imageView);
    }

    public void loadImage(String url, ImageView imageView) {
        loadImage(Uri.parse(url), imageView);
    }

    public void loadImage(Uri uri, ImageView imageView) {
        Glide.with(context)
                .load(uri)
                .into(imageView);
    }
}
