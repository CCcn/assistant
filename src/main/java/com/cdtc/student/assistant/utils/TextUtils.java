package com.cdtc.student.assistant.utils;

import javax.validation.constraints.NotNull;

/**
 * Create by pcc on 2018/4/30.
 */
public class TextUtils {

    public static boolean isEmpty(@NotNull String s) {
        return s == null || s.length() == 0;
    }
}
