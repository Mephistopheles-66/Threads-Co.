package com.Threads.Util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Utility class for handling cookies.
 */
public class CookieUtil {

    /**
     * Adds a cookie to the response.
     *
     * @param response HttpServletResponse object
     * @param name     Cookie name
     * @param value    Cookie value
     * @param maxAge   Lifetime in seconds
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * Retrieves a cookie by name from the request.
     *
     * @param request HttpServletRequest object
     * @param name    Cookie name
     * @return Cookie value, or null if not found
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * Deletes a cookie by name.
     *
     * @param response HttpServletResponse object
     * @param name     Cookie name
     */
    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
