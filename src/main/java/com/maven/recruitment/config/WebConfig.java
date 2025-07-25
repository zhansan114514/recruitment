package com.maven.recruitment.config;

import com.maven.recruitment.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**")
                                                      .excludePathPatterns("/signup")
                                                      .excludePathPatterns("/login")
                                                      .excludePathPatterns("/correcting/**")
 //                                                     .excludePathPatterns("/rank")
                                                      .excludePathPatterns("/registercode");

    }

}
