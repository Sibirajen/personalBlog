package com.sibirajen.personalBlog.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ARTICLES")
@Access(AccessType.FIELD)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTICLE_ID")
    private Long articleId;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Column(name = "AUTHOR_ID")
    private String authorId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT" ,columnDefinition = "TEXT")
    private String content;

    @Column(name = "CREATE_DATE" ,updatable = false, nullable = false)
    private LocalDate createDate;

    public Article(String authorName, String authorId, String title, String content) {
        this.authorName = authorName;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

    @PrePersist
    public void onCreate(){
        this.createDate = LocalDate.now();
    }
}