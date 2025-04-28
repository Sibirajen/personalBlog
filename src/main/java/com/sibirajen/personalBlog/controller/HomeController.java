package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.service.ArticleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ArticleService service;

    @Autowired
    public HomeController(ArticleService service){
        this.service = service;
    }

    @GetMapping(path = "/home")
    public String getHome(Model model, HttpSession session){
        List<Article> articles = service.getAllArticles();
        boolean isLoggedIn = session.getAttribute("email") != null;

        model.addAttribute("articles", articles);
        model.addAttribute("logged", isLoggedIn);

        return "home";
    }
}
