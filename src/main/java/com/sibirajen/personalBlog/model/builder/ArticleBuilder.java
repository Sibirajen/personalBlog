package com.sibirajen.personalBlog.model.builder;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.model.User;

public class ArticleBuilder {
    private String authorName;
    private User author;
    private String title;
    private String content;

    public static ArticleBuilder builder(){
        return new ArticleBuilder();
    }

    public ArticleBuilder authorName(String authorName){
        this.authorName = authorName;
        return this;
    }

    public ArticleBuilder author(User author){
        this.author = author;
        return this;
    }

    public ArticleBuilder title(String title){
        this.title = title;
        return this;
    }

    public ArticleBuilder content(String content){
        this.content = content;
        return this;
    }

    public Article build(){
        return new Article(authorName, author, title, content);
    }
}
