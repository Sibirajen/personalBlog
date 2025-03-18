package com.sibirajen.personalBlog.model;

import com.sibirajen.personalBlog.util.ShortIdGen;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String userName;
    private String password;

    @Builder
    public User(String userName, String password) {
        this.userId = ShortIdGen.getID();
        this.userName = userName;
        this.password = password;
    }
}