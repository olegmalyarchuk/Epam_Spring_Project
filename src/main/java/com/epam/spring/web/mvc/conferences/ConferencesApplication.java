package com.epam.spring.web.mvc.conferences;

import com.epam.spring.web.mvc.conferences.inperceptor.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConferencesApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(ConferencesApplication.class, args);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoggingInterceptor());
  }
}
