package com.sibirajen.personalBlog.controller;

import com.sibirajen.personalBlog.model.LoginRequest;
import com.sibirajen.personalBlog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getLogin(Model model){
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public Object postLogin(@ModelAttribute("loginRequest") LoginRequest login){
        System.out.println(login.getEmail() + " " + login.getPassword());
        if(service.isLoginOk(login.getEmail(), login.getPassword())){
            return "redirect:/home";
        }

        return "error";
    }
}
