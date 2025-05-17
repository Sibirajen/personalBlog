package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {

    private final ArticleService service;

    @Autowired
    public ArticleController(ArticleService service){
        this.service = service;
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = service.getArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("isProfile", false);
        return "article";
    }
}
