package com.sibirajen.personalBlog.controller.credential;

import com.sibirajen.personalBlog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SignUpController {
    private LoginService service;

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
                             @RequestParam(name = "password") String password){
//        System.out.println(userName + " " + emailId + " " + password);
        service.saveUser(userName, emailId, password);
        return "redirect:/login";
    }
}
