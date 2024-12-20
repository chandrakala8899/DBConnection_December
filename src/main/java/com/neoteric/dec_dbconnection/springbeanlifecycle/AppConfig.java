package com.neoteric.dec_dbconnection.springbeanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.neoteric.dec_dbconnection.springbeanlifecycle")
public class AppConfig {
    @Bean
    public MyBean myBean(DependencyBean dependencyBean) {
        return new MyBean(dependencyBean);
    }

    @Bean
    public DependencyBean dependencyBean() {
        return new DependencyBean();
    }
}
