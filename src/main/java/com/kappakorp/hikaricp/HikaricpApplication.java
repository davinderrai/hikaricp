package com.kappakorp.hikaricp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@SpringBootApplication
public class HikaricpApplication implements WebMvcConfigurer {

    private final static Logger LOGGER = Logger.getLogger(HikaricpApplication.class.getName());

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());
    }

    public static void main(String[] args) {
        SpringApplication.run(HikaricpApplication.class, args);
    }
}
