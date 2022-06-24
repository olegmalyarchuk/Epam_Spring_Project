package com.epam.spring.homework2;

import com.epam.spring.homework2.config.ConfigA;
import com.epam.spring.homework2.config.ConfigB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Hw2Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));

    }

}
