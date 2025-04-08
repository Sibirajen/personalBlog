package com.sibirajen.personalBlog.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Hash {
    public static String generate(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean compare(String password, String storedPassword){
        return BCrypt.checkpw(password, storedPassword);
    }
}
