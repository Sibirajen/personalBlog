package com.sibirajen.personalBlog.controller.credential;

import com.sibirajen.personalBlog.model.LoginRequest;
import com.sibirajen.personalBlog.service.LoginService;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("loginRequest") LoginRequest login,
                            HttpSession session,
                            Model model){
        session.setAttribute("email", login.getEmail());

        if(service.isLoginOk(login.getEmail(), login.getPassword())){
            return "redirect:/home";
        }

        model.addAttribute("error", "Invalid email or password.");
        return "login";
    }
}
