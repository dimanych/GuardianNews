package com.dimanych.guardiannews.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ListNewsPage {

    @SerializedName("results")
    public List<SimpleNews> results;
}
