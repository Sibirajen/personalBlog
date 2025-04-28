package com.sibirajen.personalBlog.controller.login;

import com.sibirajen.personalBlog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    private final LoginService service;

    @Autowired
    public SignUpController(LoginService service) {
        this.service = service;
    }

    @GetMapping("/signup")
    public String getSignUp(){
        return "signUp";
    }

    @PostMapping("/signup")
    public String postSignUp(@RequestParam(name = "name") String userName,
                             @RequestParam(name = "email") String emailId,
                             @RequestParam(name = "password") String password,
                             Model model){
        if(!service.saveUser(userName, emailId, password)){
            model.addAttribute("error", "Account already exists");
            return "signUp";
        }
        return "redirect:/login";
    }
}
