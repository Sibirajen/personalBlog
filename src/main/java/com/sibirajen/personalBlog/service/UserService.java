package com.sibirajen.personalBlog.service;

import com.sibirajen.personalBlog.model.User;
import com.sibirajen.personalBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void saveUser(User user){
        repo.save(user);
    }
}
