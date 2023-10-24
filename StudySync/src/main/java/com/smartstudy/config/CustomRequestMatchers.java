package com.smartstudy.config;

import org.springframework.security.web.util.matcher.RequestMatcher;

//import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CustomRequestMatchers {

    public static RequestMatcher publicUrls() {
        return request -> {
            String path = request.getServletPath();
            return Pattern.matches("/public/.*", path);
        };
    }

    public static RequestMatcher adminUrls() {
        return request -> {
            String path = request.getServletPath();
            return Pattern.matches("/admin/.*", path);
        };
    }
    public static RequestMatcher userDetail() {
        return request -> {
            String path = request.getServletPath();
            return Pattern.matches("/users/\\w+", path);
        };
    }
}
