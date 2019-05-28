package com.neuedu.interceptor.configurer;

import com.neuedu.interceptor.EncodingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-14 10:59
 **/

@Configuration
public class WebMvcConfigurerClass implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new EncodingInterceptor()).addPathPatterns("/**");


    }

}
