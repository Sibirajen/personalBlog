package com.sibirajen.personalBlog.service;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.model.ArticleRequest;
import com.sibirajen.personalBlog.model.User;
import com.sibirajen.personalBlog.model.builder.ArticleBuilder;
import com.sibirajen.personalBlog.repository.ArticleRepository;
import com.sibirajen.personalBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublishService {
    private final UserRepository userRepo;
    private final ArticleRepository articleRepo;

    @Autowired
    public PublishService(UserRepository userRepo, ArticleRepository articleRepo) {
        this.userRepo = userRepo;
        this.articleRepo = articleRepo;
    }

    public void postArticle(ArticleRequest articleRequest, String emailId) {
        String normalizedEmail = emailId.toLowerCase();

        Optional<User> user = userRepo.findByEmailId(normalizedEmail);

        if(user.isEmpty()) return;

        Article article = ArticleBuilder.builder()
                .title(articleRequest.getTitle())
                .authorName(user.get().getName())
                .author(user.get())
                .content(articleRequest.getContent())
                .build();

        articleRepo.save(article);
    }
}
