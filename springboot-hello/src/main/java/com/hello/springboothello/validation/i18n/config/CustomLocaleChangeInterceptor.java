package com.hello.springboothello.validation.i18n.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 中英文切换拦截
 *      由于默认是拦截request参数获取locale参数来实现的切换语言，
 *          这里我们可以改下，优先从header中获取，如果没有获取到再从request参数中获取。
 */
@Slf4j
public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        String newLocale = request.getHeader(getParamName());
        if (newLocale != null) {
            if (checkHttpMethods(request.getMethod())) {
                LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
                if (localeResolver == null) {
                    throw new IllegalStateException("No LocaleResolver found, not in a Dispatcher request?");
                }
                try {
                    localeResolver.setLocale(request, response, parseLocaleValue(newLocale));
                } catch (IllegalStateException ex) {
                    if (isIgnoreInvalidLocale()) {
                        log.debug("Ignoring invalid locale value [" + newLocale + "]: " + ex.getMessage());
                    } else {
                        throw ex;
                    }
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean checkHttpMethods(String currentMethod) {
        String[] configuredMethods = getHttpMethods();
        if (ObjectUtils.isEmpty(configuredMethods)) {
            return true;
        }
        for (String configuredMethod : configuredMethods) {
            if (configuredMethod.equalsIgnoreCase(currentMethod)) {
                return true;
            }
        }
        return false;
    }
}
