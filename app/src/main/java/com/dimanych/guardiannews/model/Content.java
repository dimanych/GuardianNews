package com.dimanych.guardiannews.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class Content {

    @SerializedName("id")
    public String id;

    @SerializedName("sectionId")
    public String sectionId;

    @SerializedName("sectionName")
    public String sectionName;

    @SerializedName("webPublicationDate")
    public Date webPublicationDate;

    @SerializedName("webTitle")
    public String webTitle;

    @SerializedName("webUrl")
    public String webUrl;
}
