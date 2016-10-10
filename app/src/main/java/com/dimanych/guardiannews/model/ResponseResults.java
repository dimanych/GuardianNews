package com.dimanych.guardiannews.model;

import com.google.gson.annotations.SerializedName;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ResponseResults<T> {
    @SerializedName("response")
    public Page<T> response;
}
