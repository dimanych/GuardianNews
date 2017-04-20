package com.dimanych.guardiannews.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.dimanych.guardiannews.model.Entity;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class SimpleNews implements Entity {

    public String id;
    public String webTitle;
    public String webUrl;
    public Date webPublicationDate;
    @SerializedName("fields")
    public Field field;
    public String apiUrl;

    public SimpleNews(String id, String webTitle, String webUrl, Date webPublicationDate, Field field, String apiUrl) {
        this.id = id;
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
        this.field = field;
        this.apiUrl = apiUrl;
    }

    public SimpleNews(Parcel in) {
        this.id = in.readString();
        this.webTitle = in.readString();
        this.webUrl = in.readString();
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
        dest.writeString(webUrl);
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof SimpleNews) {
            SimpleNews news = (SimpleNews) o;
            return this.id.equals(news.id);
        }
        return super.equals(o);
    }
}
