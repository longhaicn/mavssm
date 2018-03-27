package com.ssm.utils;

import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseUtil {
    public static void setUTF8(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}
