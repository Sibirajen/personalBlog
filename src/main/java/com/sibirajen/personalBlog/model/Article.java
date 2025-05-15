package com.sibirajen.personalBlog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "ID")
    private Long articleId;

    @Column(name = "AUTHOR_NAME")
    private String authorName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    private User author;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT" ,columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Column(name = "CREATE_DATE" ,updatable = false)
    private LocalDate createDate;

    public Article(String authorName, User author, String title, String content) {
        this.authorName = authorName;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    @PrePersist
    public void onCreate(){
        this.createDate = LocalDate.now();
    }
}