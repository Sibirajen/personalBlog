package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.service.ProfileService;
import com.sibirajen.personalBlog.util.SessionValidator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService service;

    @Autowired
    public ProfileController(ProfileService service){
        this.service = service;
    }

    @GetMapping
    public String getArticlesByProfile(Model model, HttpSession session){
        if(!SessionValidator.isSessionValid(session)){
            return "redirect:/login";
        }
        String email = (String) session.getAttribute("email");
        List<Article> articles = service.getArticleByAuthor(email);
        String authorName = service.getAuthorName(email);
        model.addAttribute("authorName", authorName);
        model.addAttribute("articles", articles);
        return "profile";
    }
}
