package com.ecomlogix.cms.util;

import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by eric on 19/06/2016.
 */
public class UrlUtil {
    public static String encodeUrlPath(String pathSegment, HttpServletRequest httpServletRequest) {

        String encoding = httpServletRequest.getCharacterEncoding() == null ? WebUtils.DEFAULT_CHARACTER_ENCODING : httpServletRequest.getCharacterEncoding();

        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, encoding);
        } catch (UnsupportedEncodingException e) {
            //
        }

        return pathSegment;
    }
}