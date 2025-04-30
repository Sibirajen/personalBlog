package com.sibirajen.personalBlog.util;

import jakarta.servlet.http.HttpSession;

public class SessionValidator {
    public static boolean isSessionValid(HttpSession session){
        return session != null && session.getAttribute("email") != null;
    }
}
