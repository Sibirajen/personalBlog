package com.sibirajen.personalBlog.util.enums;

public enum Type {
    ARTICLE("article_"),
    USER("user_");

    private String string;

    Type(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}