package com.du.car.config;

import com.du.car.filter.SmsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 21:11
 **/
@Configuration
public class FilterConfig {
    //SpringBoot项目注册过滤器
    @Bean
    public FilterRegistrationBean createFR() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SmsFilter());
        bean.addUrlPatterns("/*.do");
        return bean;
    }


}
