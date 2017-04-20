package com.dimanych.guardiannews.model.api;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class Content {

    public String id;

    public String sectionId;

    public String sectionName;

    public Date webPublicationDate;

    public String webTitle;

    public String webUrl;

    @Nullable
    @SerializedName("fields")
    public Field field;
}
