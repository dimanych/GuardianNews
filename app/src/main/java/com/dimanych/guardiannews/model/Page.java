package com.dimanych.guardiannews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class Page<T> {
    @SerializedName("results")
    public List<T> data;
}
