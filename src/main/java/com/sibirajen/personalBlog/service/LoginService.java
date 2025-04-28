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

    public boolean saveUser(String userName, String emailId, String password) {
        String normalizedEmailId = emailId.toLowerCase();
        if(repo.existsByEmailId(normalizedEmailId)){
            return false;
        }

        User user = new User(userName, Hash.generate(password), normalizedEmailId);
//        System.out.println(user.getName() + " " + user.getEmailId() + " " + user.getPassword());
        repo.save(user);
        return true;
    }

    public boolean validateCred(String emailId, String password) {
        String normalizedEmailId = emailId.toLowerCase();
        Optional<User> user = repo.findByEmailId(normalizedEmailId);
        return user.isPresent() && Hash.compare(password, user.get().getPassword());
    }
}
