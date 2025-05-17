package com.sibirajen.personalBlog.service;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.model.ArticleRequest;
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

    public Article getArticle(Long id){
        return articleRepo.findById(id).orElse(new Article());
    }

    public String getAuthorName(String email){
        Optional<User> user = userRepo.findByEmailId(email);
        return user.map(User::getName).orElse(null);
    }

    public void deleteArticle(long id) {
        articleRepo.deleteById(id);
    }

    public void update(long id, ArticleRequest articleRequest) {
        Article article = getArticle(id);
        article.setTitle(articleRequest.getTitle());
        article.setContent(articleRequest.getContent());
        articleRepo.save(article);
    }
}
