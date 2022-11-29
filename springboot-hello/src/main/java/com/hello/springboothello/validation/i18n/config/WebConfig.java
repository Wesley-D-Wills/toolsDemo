package com.hello.springboothello.validation.i18n.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    // lang param name in header, default to 'locale'
    private static final String LANGUAGE_PARAM_NAME = LocaleChangeInterceptor.DEFAULT_PARAM_NAME;

    // message source
    // @Autowired
    private final ResourceBundleMessageSource resourceBundleMessageSource;
    // @Autowired
    // private MessageSource messageSource;

    // default locale
    @Bean
    // @Bean 注解在返回的实例的方法上，如果未通过@Bean指定bean的名称，则默认id就是方法名称与方法名相同，类型就是方法的返回值
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return localeResolver;
    }

    // local validator factory bean
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        factoryBean.setValidationMessageSource(resourceBundleMessageSource);
        // factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }

    // locale change interceptor
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new CustomLocaleChangeInterceptor();
        interceptor.setParamName(LANGUAGE_PARAM_NAME);
        return interceptor;
    }

    // register locale change interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

//    @Override
//    public Validator getValidator() {
//        return localValidatorFactoryBean();
//    }
}
