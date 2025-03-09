package com.sibirajen.personalBlog.util.enums;

import lombok.Getter;

@Getter
public enum Type {
    ARTICLE("article_"),
    USER("user_");

    private final String string;

    Type(String string) {
        this.string = string;
    }

}