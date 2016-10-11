package com.dimanych.guardiannews.model.api;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class Field implements Serializable {

    @Nullable
    @SerializedName("thumbnail")
    public String thumbnail;


}
