package com.lefting.api.common.config;

import com.lefting.hybrid.common.filter.SiteMeshFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@Order(2)
@ComponentScan(basePackages= {"com.jhlee.minipj.hybrid"})
@EnableWebMvc
public class AppApiInterceptorConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(AppApiInterceptorConfig.class);

    @Autowired
    @Qualifier(value = "apiInterceptor")
    private HandlerInterceptor apiIterceptor;

    public AppApiInterceptorConfig() {
        super();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info(">>>>>>>>>>>>>>>>>ready addInterceptors");
        registry.addInterceptor(apiIterceptor).addPathPatterns("/**").excludePathPatterns("/auth/**", "/api/login","/member/**","/hybrid/member/**","/hybrid/term/*","/assets/**");
    }

    /*
    @Bean
    public MappedInterceptor myInterceptor() {
        return new MappedInterceptor(null, interceptor);
    }
    */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info(">>>>>>>>>>>>>>>>>ready add resouce handler");
        registry
                 .addResourceHandler("/assets/**")
                //.addResourceLocations("C:\\workspace_intellij\\juvis-server-p2\\src\\main\\webapp\\assets\\")
                .addResourceLocations("/assets/")
                .setCachePeriod(0)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new PathResourceResolver());
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        logger.info(">>>>>>>>>>>>>>>>>InternalResourceViewResolver");

        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new SiteMeshFilter());

        return filter;
    }

    /*
    @Bean
    public FilterRegistrationBean<JuvisAPIFilter> loggingFilter(){
        FilterRegistrationBean<JuvisAPIFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JuvisAPIFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(0);

        return registrationBean;
    }
    */

    /*
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        logger.info(">>>>>>>>>>>>>>>>>addArgumentResolvers");
        argumentResolvers.add(new AuthVOHandlerMethodArgumentResolver());
    }
    */

    /*
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //super.configureMessageConverters(converters);

        // 5. WebMvcConfigurerAdapter에 MessageConverter 추가
        converters.add(htmlEscapingConveter());
    }

    private HttpMessageConverter<?> htmlEscapingConveter() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 3. ObjectMapper에 특수 문자 처리 기능 적용
        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());

        // 4. MessageConverter에 ObjectMapper 설정
        MappingJackson2HttpMessageConverter htmlEscapingConverter = new MappingJackson2HttpMessageConverter();
        htmlEscapingConverter.setObjectMapper(objectMapper);

        return htmlEscapingConverter;
    }
    */

    /*
    // RequestMappingHandlerMapping를 WebMvcConfigurer보다 먼저 적용시키는 듯
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping rm = new RequestMappingHandlerMapping();
        rm.setInterceptors(interceptor);
        return rm;
    }
    */

}
