package com.lefting.api.common;

import com.lefting.api.common.config.MessageConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class MesssageSource {


    @Bean
    public MessageSource messageSource(MessageConfig config) {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename(config.getBasename());
        messageSource.setDefaultEncoding(config.getEncode());

        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver(MessageConfig config) {
        SessionLocaleResolver locale = new SessionLocaleResolver();
        locale.setDefaultLocale(config.getLocale());

        return locale;
    }


}
