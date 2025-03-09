package com.sibirajen.personalBlog.model;

import com.sibirajen.personalBlog.util.ShortIdGen;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Article {
    private String id;
    private String title;
    private String content;
    private LocalDate createDate;
    private LocalDate updateDate;

    @Builder
    public Article(String title, String content, LocalDate createDate, LocalDate updateDate) {
        this.id = ShortIdGen.getID();
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
