package com.sibirajen.personalBlog.service;

import com.sibirajen.personalBlog.model.User;
import com.sibirajen.personalBlog.repository.UserRepository;
import com.sibirajen.personalBlog.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository repo;

    @Autowired
    public LoginService(UserRepository repo) {
        this.repo = repo;
    }

    public void saveUser(String userName, String emailId, String password) {
        if(!repo.existsByEmailId(emailId)){
            User user = new User(userName, Hash.generate(password), emailId);
            System.out.println(user.getName() + " " + user.getEmailId() + " " + user.getPassword());
            repo.save(user);
        }
    }

    public boolean isLoginOk(String emailId, String password) {
        Optional<User> user = repo.findByEmailId(emailId);
        return user.isPresent() && Hash.compare(password, user.get().getPassword());
    }
}
