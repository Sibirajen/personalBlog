package com.sibirajen.personalBlog.util;

import com.sibirajen.personalBlog.util.enums.Type;

public class GenerateFileID {
    public static String getId(String id, Type type){
        return type.getString() + id;
    }
}
