package com.sibirajen.personalBlog.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {
    private String id;
    private String title;
    private String content;
    private LocalDate createDate;
    private LocalDate updateDate;
}
