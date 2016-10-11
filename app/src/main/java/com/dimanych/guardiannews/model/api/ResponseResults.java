package com.dimanych.guardiannews.model.api;

import com.google.gson.annotations.SerializedName;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ResponseResults<T> {

    @SerializedName("response")
    public T response;
}
