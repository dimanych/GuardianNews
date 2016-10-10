package com.dimanych.guardiannews.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class SimpleNews implements Entity {

    @SerializedName("id")
    public String id;
    @SerializedName("webTitle")
    public String webTitle;
    @SerializedName("webPublicationDate")
    public Date webPublicationDate;
    @SerializedName("fields")
    public Field field;
    @SerializedName("apiUrl")
    public String apiUrl;

    public SimpleNews(String id, String webTitle, Date webPublicationDate, Field field, String apiUrl) {
        this.id = id;
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.field = field;
        this.apiUrl = apiUrl;
    }

    public SimpleNews(Parcel in) {
        this.id = in.readString();
        this.webTitle = in.readString();
        this.webPublicationDate = (Date) in.readSerializable();
        this.field = (Field) in.readSerializable();
        this.apiUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(webTitle);
        dest.writeSerializable(webPublicationDate);
        dest.writeSerializable(field);
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
