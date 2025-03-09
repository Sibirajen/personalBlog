package com.sibirajen.personalBlog.model;

import com.sibirajen.personalBlog.util.ShortIdGen;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Article {
    private String id;
    private String title;
    private String content;
    private LocalDate createDate;
    private LocalDate updateDate;

    public Article(String title, String content, LocalDate createDate, LocalDate updateDate) {
        this.id = ShortIdGen.getID();
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
