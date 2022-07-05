package com.epam.spring.homework2.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class BeanB extends OurBean {

    public BeanB() {

    }

    public BeanB(String name, int value) {
        super(name, value);
    }

    public void doInitA() {
        System.out.println("Initiating BeanB by doInitA");
    }

    public void doInitB() {
        System.out.println("Initiating BeanB by doInitB");
    }

    public void doDestroy() {
        System.out.println("Destroying Bean B");
    }
}
