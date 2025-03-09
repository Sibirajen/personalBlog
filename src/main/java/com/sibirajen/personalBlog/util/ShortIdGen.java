package com.sibirajen.personalBlog.util;

public class ShortIdGen {
    public static String getID() {
        return Long.toHexString(System.nanoTime());
    }
}
