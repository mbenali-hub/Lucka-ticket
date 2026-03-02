package com.benali.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.RequestContextFilter;

import com.benali.feign.Interceptor;

import feign.Logger;

@Configuration
public class FeignConfig {

    // @Bean
    // public TokenContext tokenContext(){
    //     return new TokenContext();
    // }
    @Bean
    public Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }

    @Bean
    public Interceptor interceptor(){
        return new Interceptor();
    }

    @Bean
    public FilterRegistrationBean<RequestContextFilter> requestContextFilter() {
        FilterRegistrationBean<RequestContextFilter> bean = new FilterRegistrationBean<>();
        RequestContextFilter filter = new RequestContextFilter();
        filter.setThreadContextInheritable(true); 
        bean.setFilter(filter);
        return bean;
    }
    // @Bean
    // public HeaderModification headerModification(TokenContext t){
    //     return new HeaderModification(t);
    // }

}
