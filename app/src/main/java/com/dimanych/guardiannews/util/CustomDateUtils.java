package com.dimanych.guardiannews.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class CustomDateUtils {

    public static String convertDateToStr(Date date) {
        if (Objects.nonNull(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd MMM yyyy");
            return String.valueOf(sdf.format(date.getTime()));
        }
        return "";
    }
}
