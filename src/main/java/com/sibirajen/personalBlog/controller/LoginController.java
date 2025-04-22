package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginService service;

    @Autowired
    public LoginController(LoginService service) {
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
        System.out.println(userName + " " + emailId + " " + password);
        service.saveUser(userName, emailId, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PostMapping("/login")
    public Object postLogin(@RequestParam(name = "email") String emailId,
                            @RequestParam(name = "password") String password){
        System.out.println(emailId + " " + password);
        if(service.isLoginOk(emailId, password)){
            return "redirect:/home";
        }

        return "error";
    }
}
