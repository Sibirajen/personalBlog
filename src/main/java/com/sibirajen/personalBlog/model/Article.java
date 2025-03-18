package com.sibirajen.personalBlog.model;

import com.sibirajen.personalBlog.util.ShortIdGen;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Article {
    private String articleId;
    private String authorName;
    private String authorId;
    private String title;
    private String content;
    private LocalDate createDate;

    @Builder
    public Article(String authorName, String authorId, String title, String content, LocalDate createDate) {
        this.articleId = ShortIdGen.getID();
        this.authorName = authorName;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }
}