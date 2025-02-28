package com.example.demo.configuration;

import com.example.demo.configuration.CSPHeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

//    @Bean
//    public FilterRegistrationBean<CSPHeaderFilter> loggingFilter() {
//        FilterRegistrationBean<CSPHeaderFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CSPHeaderFilter());
//        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
//        return registrationBean;
//    }
}
