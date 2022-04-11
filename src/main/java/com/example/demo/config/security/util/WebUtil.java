package com.example.demo.config.security.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebUtil {
    private static final String CONTENT_TYPE = "Content-type";
    private static final String CONTENT_TYPE_JSON = "application/json";

    private static final String SPECIAL_REQUEST = "Platform-Token";
    //private static final String X_REQUESTED_WITH = "X-Requested-With";
    private static final String PLATFORM_TOKEN = "Platform-Token";

    public static boolean isContentTypeJson(HttpServletRequest request) {
        return request.getHeader(CONTENT_TYPE).contains(CONTENT_TYPE_JSON);
    }

    public static boolean isApi(HttpServletRequest request) {
        return SPECIAL_REQUEST.equals(request.getHeader(PLATFORM_TOKEN));
    }

}
