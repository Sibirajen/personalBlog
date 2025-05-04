package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.ArticleRequest;
import com.sibirajen.personalBlog.service.ProfileService;
import com.sibirajen.personalBlog.util.SessionValidator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/profile")
public class ProfileController {
    private final ProfileService service;

    @Autowired
    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @PostMapping("/profile/publish")
    public String postArticle(HttpSession session,
                              @ModelAttribute ArticleRequest articleRequest) {
        if (!SessionValidator.isSessionValid(session))
            return "redirect:/login";

        String email = (String) session.getAttribute("email");
        long id = service.postArticle(articleRequest, email);
        return "redirect:/article/" + id;
    }
}
