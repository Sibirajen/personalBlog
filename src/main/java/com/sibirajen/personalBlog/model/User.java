package com.sibirajen.personalBlog.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "AUTHORS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AUTHOR_NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL_ID", unique = true)
    private String emailId;

    @OneToMany(mappedBy = "author")
    private List<Article> articles = new ArrayList<>();

    public User(String name, String password, String emailId) {
        this.name = name;
        this.password = password;
        this.emailId = emailId;
    }
}