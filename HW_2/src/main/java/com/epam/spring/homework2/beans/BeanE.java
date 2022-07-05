package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE extends OurBean {
    public BeanE() {

    }

    public BeanE(String name, int value) {
        super(name, value);
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("Calling postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Calling preDestroy");
    }

}
