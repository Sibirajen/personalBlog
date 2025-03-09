package com.sibirajen.personalBlog.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
    private final JsonFileDatabase database;

    public ArticleRepository() {
        this.database = new JsonFileDatabase("/articles");
    }
}
