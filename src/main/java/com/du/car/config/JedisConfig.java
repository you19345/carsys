package com.du.car.config;

import com.du.car.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: carsys
 * @description:
 * @author: You毒
 * @create: 2019-12-11 21:05
 **/
@Configuration
public class JedisConfig {
    @Bean
//    ioc 创建对象的方式：1、单例 singleton 2、多例 调用就是创建
//    @Scope(scopeName = "singleton")
    public JedisUtil createJU() {
        return new JedisUtil();
    }
}
