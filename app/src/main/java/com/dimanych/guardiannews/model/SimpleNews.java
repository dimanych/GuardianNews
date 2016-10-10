package com.dimanych.guardiannews.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class SimpleNews implements Entity {

    @SerializedName("webTitle")
    public String webTitle;
    @SerializedName("webPublicationDate")
    public String webPublicationDate;
    @SerializedName("thumbnail")
    public String thumbnail;
    @SerializedName("apiUrl")
    public String apiUrl;

    public SimpleNews(String webTitle, String webPublicationDate, String thumbnail, String apiUrl) {
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.thumbnail = thumbnail;
        this.apiUrl = apiUrl;
    }

    public SimpleNews(Parcel in) {
        this.webTitle = in.readString();
        this.webPublicationDate = (String) in.readSerializable();
        this.thumbnail = in.readString();
        this.apiUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(webTitle);
        dest.writeSerializable(webPublicationDate);
        dest.writeString(thumbnail);
        dest.writeString(apiUrl);
    }

    public static final Parcelable.Creator CREATOR = new Creator() {
        @Override
        public SimpleNews createFromParcel(Parcel source) {
            return new SimpleNews(source);
        }

        @Override
        public SimpleNews[] newArray(int size) {
            return new SimpleNews[size];
        }
    };
}
