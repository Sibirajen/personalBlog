package com.sibirajen.personalBlog.service;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.model.User;
import com.sibirajen.personalBlog.repository.ArticleRepository;
import com.sibirajen.personalBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ArticleRepository articleRepo;
    private final UserRepository userRepo;

    @Autowired
    public ProfileService(ArticleRepository articleRepo, UserRepository userRepo) {
        this.articleRepo = articleRepo;
        this.userRepo = userRepo;
    }

    public List<Article> getArticleByAuthor(String email) {
        Optional<User> user = userRepo.findByEmailId(email);
        if(user.isPresent()){
            return articleRepo.findByAuthorId(user.get().getId());
        }
        return new ArrayList<>();
    }
}
