package com.dimanych.guardiannews.model;

import com.google.gson.annotations.SerializedName;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ResponseData<T> {
    @SerializedName("response")
    public Page<T> response;
}
