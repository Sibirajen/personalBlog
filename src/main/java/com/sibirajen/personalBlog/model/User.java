package com.sibirajen.personalBlog.model;

import com.sibirajen.personalBlog.util.ShortIdGen;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String name;
    private String password;
    private List<String> articles;

    @Builder
    public User(String name, String password, List<String> articles) {
        this.id = ShortIdGen.getID();
        this.name = name;
        this.password = password;
        this.articles = articles;
    }
}