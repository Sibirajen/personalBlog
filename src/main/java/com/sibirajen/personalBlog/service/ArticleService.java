package com.sibirajen.personalBlog.service;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository repo;

    @Autowired
    public ArticleService(ArticleRepository repo) {
        this.repo = repo;
    }

    public Article getArticle(String id){
        return repo.getArticleById(id);
    }

    public List<Article> getAllArticles() {
        return repo.getArticles();
    }
}
