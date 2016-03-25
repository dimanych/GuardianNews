package com.dimanych.guardiannews.util;

/**
 * <p>
 *   Утилита операций над объектами
 * </p>
 *
 * @author Dmitriy Grigoriev
 */
public abstract class Objects {

  /**
   * @param o объект для проверки
   * @return флаг проверки объекта o на не null
   */
  public static boolean nonNull(Object o) {
    return o != null;
  }

  /**
   * @param o объект для проверки
   * @return флаг проверки объекта o на null
   */
  public static boolean isNull(Object o) {
    return o == null;
  }

  /**
   * Сравнить строки с проверкой на null
   * @return флаг сравнения
   */
  public static int compare(String o1, String o2) {
    int compare = 0;
    if (isNull(o1)) {
      if (nonNull(o2)) {
        compare = -1;
      }
    } else {
      if (nonNull(o2)) {
        compare = o1.compareTo(o2);
      } else {
        compare = 1;
      }
    }
    return compare;
  }
  /**
   * Сравнить челые числа с проверкой на null
   * @return флаг сравнения
   */
  public static int compare(Integer o1, Integer o2) {
    int compare = 0;
    if (isNull(o1)) {
      if (nonNull(o2)) {
        compare = -1;
      }
    } else {
      if (nonNull(o2)) {
        compare = o1.compareTo(o2);
      } else {
        compare = 1;
      }
    }
    return compare;
  }
}
