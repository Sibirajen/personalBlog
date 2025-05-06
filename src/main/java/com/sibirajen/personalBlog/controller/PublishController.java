package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.ArticleRequest;
import com.sibirajen.personalBlog.service.PublishService;
import com.sibirajen.personalBlog.util.SessionValidator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PublishController {
    private final PublishService service;

    @Autowired
    public PublishController(PublishService service) {
        this.service = service;
    }

    @GetMapping("/publish")
    public String getArticle(HttpSession session, Model model){
        if (!SessionValidator.isSessionValid(session))
            return "redirect:/login";

        model.addAttribute("logged", true);
        return "publish";
    }

    @PostMapping("/publish")
    public String postArticle(HttpSession session,
                              @ModelAttribute ArticleRequest articleRequest) {
        if (!SessionValidator.isSessionValid(session))
            return "redirect:/login";

        String email = (String) session.getAttribute("email");
        long id = service.postArticle(articleRequest, email);
        return "redirect:/article/" + id;
    }
}
