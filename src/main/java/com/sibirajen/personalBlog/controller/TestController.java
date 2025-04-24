package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.model.User;
import com.sibirajen.personalBlog.service.ArticleService;
import com.sibirajen.personalBlog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private UserService userService;
    private ArticleService articleService;

    @Autowired
    public TestController(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @GetMapping("/")
    public void getTest(){
        User sibi = new User("Sibirajen", "Sibi(2003)", "Sibirajen16@gmail.com");

        userService.saveUser(sibi);

        long userId = sibi.getId();
        String userName = sibi.getName();

        Article article = new Article(userName, sibi, "Title", "Content");
        articleService.saveArticle(article);
    }

    @PostMapping("/set")
    public String setSession(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        return "Session attribute 'username' set!";
    }

    @GetMapping("/get")
    public String getSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "Session attribute 'username' is: " + (username != null ? username : "not set");
    }

    @PostMapping("/invalidate")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "Session invalidated!";
    }
}
