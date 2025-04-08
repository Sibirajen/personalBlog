package com.sibirajen.personalBlog.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "AUTHORS")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUTHOR_ID")
    private Long authorId;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL_ID", unique = true)
    private String emailId;

    public Authors(String authorName, String password, String emailId) {
        this.authorName = authorName;
        this.password = password;
        this.emailId = emailId;
    }
}