package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.Article;
import com.sibirajen.personalBlog.model.ArticleRequest;
import com.sibirajen.personalBlog.service.ProfileService;
import com.sibirajen.personalBlog.util.SessionValidator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/article/{id}")
    public String getArticleByProfile(@PathVariable long id, HttpSession session, Model model){
        if(!SessionValidator.isSessionValid(session)){
            return "redirect:/login";
        }
        Article article = service.getArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("isProfile", true);
        return "article";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticleById(@PathVariable long id, HttpSession session){
        if(!SessionValidator.isSessionValid(session)){
            return "redirect:/login";
        }

        service.deleteArticle(id);
        return "redirect:/profile";
    }

    @GetMapping("/edit/{id}")
    public String getArticleToEdit(@PathVariable long id, HttpSession session, Model model){
        if(!SessionValidator.isSessionValid(session)){
            return "redirect:/login";
        }
        Article article = service.getArticle(id);
        model.addAttribute("logged", true);
        model.addAttribute("article", article);
        return "edit";
    }

    @PutMapping("/edit/{id}")
    public String updateArticle(@PathVariable long id, HttpSession session,
                                @ModelAttribute ArticleRequest articleRequest){
        if(!SessionValidator.isSessionValid(session)){
            return "redirect:/login";
        }
        service.update(id, articleRequest);
        return "redirect:/profile";
    }
}
