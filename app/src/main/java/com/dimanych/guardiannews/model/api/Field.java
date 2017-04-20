package com.dimanych.guardiannews.model.api;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class Field implements Serializable {

    @Nullable
    public String thumbnail;

    @Nullable
    public String body;

    @Nullable
    public String bodyText;

    @Nullable
    public String byline;

    @Nullable
    public String trailText;

    @Nullable
    public String headline;

    @Nullable
    public String score;


}
