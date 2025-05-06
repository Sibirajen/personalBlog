package com.sibirajen.personalBlog.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ArticleRequest {
    private String title;
    private String content;
}
